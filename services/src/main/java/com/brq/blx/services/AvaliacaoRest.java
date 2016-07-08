package com.brq.blx.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import com.brq.blx.persistence.AvaliacaoDao;

import com.brq.blx.entity.Avaliacao;

@Path("/avaliacao")
public class AvaliacaoRest {

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Avaliacao av) {
		JsonObject obj = new JsonObject();
		try{
			AvaliacaoDao.getInstance().cadastrar(av);
			obj.addProperty("result", "Avaliação cadastrada!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Avaliação não cadastrada!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
}
