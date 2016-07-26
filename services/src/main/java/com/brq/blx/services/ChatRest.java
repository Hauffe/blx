package com.brq.blx.services;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.brq.blx.entity.Room;

@ServerEndpoint(value = "/chatRoomEndPoint/{idUsuarioA}/{idUsuarioB}")
public class ChatRest {

	static List<Room> rooms = new ArrayList<Room>();
	
	@OnOpen
	public void handleOpen(@PathParam("idUsuarioA") String idUsuarioA, @PathParam("idUsuarioB") String idUsuarioB, Session userSession) {
		Room room;
		StringBuilder codRoom = new StringBuilder();
				
		userSession.getUserProperties().put("idUsuarioA", idUsuarioA);
		
		codRoom.append(userSession.getUserProperties().get("idUsuarioA").toString());
		codRoom.append("/");
		codRoom.append(idUsuarioB);
		
		room = new Room(codRoom.toString());
		
		Integer resultCheckRoom = checkRoom(room);
		
		if ( resultCheckRoom != -1 ) {
			room = rooms.get(resultCheckRoom);
			addUser(room, userSession);
		}
		
		else {
			addUser(room, userSession);
			rooms.add(room);
		}
		
		userSession.getUserProperties().put( "room", room );
	}
	
	private boolean addUser(Room room, Session userSession) {
		if (room.getUsuario_A() == null)
			room.setUsuario_A(userSession);
		
		else if (room.getUsuario_B() == null)
			room.setUsuario_B(userSession);
		
		else
			return false;
		
		return true;
	}
	
	private Integer checkRoom(Room room) {
		for(int i = 0; i < rooms.size(); i++) {
			Room roomAuxiliar = rooms.get(i);
			
			if ( roomAuxiliar.equals(room) ) {
				return i;
			}
		}
		return -1;
	}

	@OnClose
	public void handleClose(Session userSession) {		
		Room room;
		
		Integer resultCheckRoom = checkRoom( (Room) userSession.getUserProperties().get("room") );
		
		if ( resultCheckRoom != -1) {
			room = rooms.get( resultCheckRoom );
			room.remove( userSession );
		}
	}
	
	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		Room room;
		
		room = rooms.get( checkRoom((Room) userSession.getUserProperties().get("room")) );
		
		String userName = (String) userSession.getUserProperties().get("userName");
		
		if(userName == null) {
			userSession.getUserProperties().put("userName", message);
			userSession.getBasicRemote().sendText(buildJsonData("System", "You are now connected as " + message));;
		
		} else {
			Iterator<Session> iterator = room.getUsuarios().iterator();
			
			while(iterator.hasNext())
				iterator.next().getBasicRemote().sendText(buildJsonData(userName, message));
		}
	}
	
	private String buildJsonData(String userName, String message) {
		JsonObject jsonObject = Json.createObjectBuilder().add("message", userName + ": " + message).build();
		StringWriter stringWriter = new StringWriter();
		
		try {
			JsonWriter jsonWriter = Json.createWriter(stringWriter);
			jsonWriter.write(jsonObject);
		
		} catch(Exception error) {
			error.printStackTrace();
		}
			
		return stringWriter.toString();
	}
}
