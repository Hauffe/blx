package com.brq.blx.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.brq.blx.persistence.UsuarioDao;

@Path("/usuario")
public class UsuarioRest {

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Usuario u) {
		JsonObject obj = new JsonObject();
		try{
//			new UsuarioDao().cadastrar(u);
			UsuarioDao.getInstance().cadastrar(u);
			obj.addProperty("result", "Usuário cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não cadastrado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@POST
	@Path("/editar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Usuario u) {
		JsonObject obj = new JsonObject();
		try{
//			new UsuarioDao().atualizar(u);
			UsuarioDao.getInstance().atualizar(u);
			obj.addProperty("result", "Usuário atualizado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não atualizado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/autenticar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(Usuario u) {
		JsonObject obj = new JsonObject();
		try{
//			Boolean res = new UsuarioDao().verificar(u);
//			if(res) {
//				obj.addProperty("result", "OK");
//			} else {
//				obj.addProperty("result", "NOK");
//			}
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "NOK");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/buscarPorId/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") String id) {
		JsonObject obj = new JsonObject();
		try{
			Usuario usuario = new UsuarioDao().buscarPorId(new Integer(id));
			if(usuario != null) {
				obj.addProperty("result", new Gson().toJson(usuario));
			} else {
				obj.addProperty("result", "Usuário não encontrado");
			}
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não encontrado");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/buscar/{busca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("busca") String busca) {
		JsonObject obj = new JsonObject();
		try{
//			List<Usuario> usuarios = new ArrayList<>();
//			usuarios = new UsuarioDao().buscarUsuarios(busca);
//			if(usuarios.size() > 0) {
//				obj.addProperty("result", new Gson().toJson(usuarios));
//			} else {
//				obj.addProperty("result", "Usuário não encontrado");
//			}
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não encontrado");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
}
