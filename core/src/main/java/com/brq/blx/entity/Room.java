package com.brq.blx.entity;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

public class Room {
	
	private Integer hashCode;
	private String codRoom;
	private Session usuario_A;
	private Session usuario_B;
	
	public Room() {}

	public Room(String codRoom) {
		this.codRoom = codRoom;
	}

	public Session getUsuario_A() {
		return usuario_A;
	}

	public void setUsuario_A(Session usuario_A) {
		this.usuario_A = usuario_A;
	}

	public Session getUsuario_B() {
		return usuario_B;
	}

	public void setUsuario_B(Session usuario_B) {
		this.usuario_B = usuario_B;
	}

	public String getCodRoom() {
		return codRoom;
	}

	public void setCodRoom(String codRoom) {
		this.codRoom = codRoom;
	}
	
	public boolean remove(Session userSession) {
		Integer idUsuario;
		Integer idUsuario_p = (Integer) userSession.getUserProperties().get("idUsuario");
		
		idUsuario = (Integer) this.getUsuario_A().getUserProperties().get("idUsuario");
		
		if ( idUsuario == idUsuario_p ) {
			this.setUsuario_A(null);
			return true;
		}
		
		idUsuario = (Integer) this.getUsuario_B().getUserProperties().get("idUsuario");
		
		if ( idUsuario == idUsuario_p ) {
			this.setUsuario_B(null);
			return true;
		}
			
		return true;
	}
	
	public List<Session> getUsuarios() {
		List<Session> usuarios = new ArrayList<Session>();
		
		if ( this.getUsuario_A() != null) 
			usuarios.add(this.getUsuario_A());
		
		if ( this.getUsuario_B() != null )
			usuarios.add(this.getUsuario_B());
		
		return usuarios;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Room))
			return false;
		
		if ( !((Room) obj).getCodRoom().equals(this.getCodRoom()) ) 
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode() {
		return this.hashCode;
	}
}