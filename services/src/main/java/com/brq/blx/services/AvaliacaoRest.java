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
import com.google.gson.GsonBuilder;

@Path("/avaliacao")
public class AvaliacaoRest {

	private Gson gson;
	
	@Inject
	private AvaliacaoDao avaliacaoDao;
	
	public AvaliacaoRest() {
		super();
		this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Avaliacao av) {
		try{
			avaliacaoDao.cadastrar(av);
			return Response.ok(gson.toJson("Avaliacao cadastrada!")).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Avaliacao nao cadastrada!")).build();
		}
	}
}
