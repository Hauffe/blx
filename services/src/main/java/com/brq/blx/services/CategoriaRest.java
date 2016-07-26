

package com.brq.blx.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Categoria;
import com.brq.blx.persistence.CategoriaDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/categoria")
public class CategoriaRest {
	
	private Gson gson;
	
	@Inject
	private CategoriaDao categoriaDao;
	
	public CategoriaRest() {
		super();
		this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar(){
		try {
			List<Categoria> categorias = new ArrayList<>();
			
			categorias = categoriaDao.buscarTodos("Categoria");
			
			if (categorias.size() > 0)
				return Response.ok(gson.toJson(categorias)).build();

			return Response.ok(gson.toJson("Nenhuma Categoria")).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
}
