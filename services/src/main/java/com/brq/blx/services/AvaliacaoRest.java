package com.brq.blx.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Avaliacao;
import com.brq.blx.persistence.AvaliacaoDao;
import com.google.gson.Gson;

@Path("/avaliacao")
public class AvaliacaoRest {

	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Avaliacao av) {
		try{
			avaliacaoDao.cadastrar(av);
			return Response.ok(new Gson().toJson("Avaliacao cadastrada!")).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok(new Gson().toJson("Avaliacao nao cadastrada!")).build();
		}
	}
}
