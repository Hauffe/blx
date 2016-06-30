package com.brq.blx.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import blx.entity.Livro;
import blx.persistence.LivroDao;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/livro")
public class LivroRest {

	@GET
	@Path("/teste")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		
		return Response.ok(new Gson().toJson("TESTE MAVEN")).build();
	}
	
	@POST
	@Path("cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Livro l) {
		JsonObject obj = new JsonObject();
		try{
			new LivroDao().cadastrar(l);
			obj.addProperty("result", "Livro cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Livro nao cadastrado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
}
