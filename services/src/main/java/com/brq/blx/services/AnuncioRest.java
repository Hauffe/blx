package com.brq.blx.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Categoria;
import com.brq.blx.entity.Contato;
import com.brq.blx.entity.TipoUsuario;
import com.brq.blx.entity.Usuario;
import com.brq.blx.persistence.AnuncioDao;
import com.brq.blx.persistence.CategoriaDao;
import com.brq.blx.persistence.ContatoDao;
import com.brq.blx.persistence.UsuarioDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/anuncio")
public class AnuncioRest {

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Anuncio a) {
		try{
			a.setDtAnuncio(new Date());
			a.setVlStatus(1);
			
			AnuncioDao.getInstance().cadastrar(a);
			return Response.ok(new Gson().toJson("Anuncio cadastrado!")).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new Gson().toJson("Anuncio nao cadastrado!")).build();
		}
		
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Anuncio a) {
		JsonObject obj = new JsonObject();
		try{
			AnuncioDao.getInstance().atualizar(a);
			// cadastrar alteracao aqui em algum lugar, procurar sentido dessa classe
			obj.addProperty("result", "Anúncio alterado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Anúncio não alterado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		JsonObject obj = new JsonObject();
		try{
			List<Anuncio> anuncios = new ArrayList<>();
//			anuncios = new AnuncioDao().listar(u);
			anuncios = AnuncioDao.getInstance().buscarTodos();
			if(anuncios.size() > 0) 
				obj.addProperty("result", new Gson().toJson(anuncios));
			else
				obj.addProperty("result", "Nenhum Anuncio");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Nenhum Anuncio");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/pegarAnuncio/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response anuncio(@PathParam("id") String id) {
		try{
			Anuncio a = AnuncioDao.getInstance().buscarPorId(new Integer(id));
			if(a != null)
				return Response.ok(new Gson().toJson(a)).build();
			else 
				return Response.ok(new Gson().toJson("anuncio não encontrado")).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok(new Gson().toJson("anuncio não encontrado")).build();
		}
		
	}
	
	@GET
	@Path("/buscar/{busca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("busca") String busca) {
		JsonObject obj = new JsonObject();
		try{
			List<Anuncio> anuncios = new ArrayList<>();
//			anuncios = new AnuncioDao().buscarAnuncios(busca);
//			if(anuncios.size() > 0)
//				obj.addProperty("result", anuncios);
//			else
//				obj.addProperty("result", "Anuncio não encontrado");
//			
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Anuncio não encontrado");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/meusAnuncios/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response meusAnuncios(@PathParam("id") String id) {
		JsonObject obj = new JsonObject();
		try{
			List<Anuncio> anuncios = new ArrayList<>();
//			anuncios = new AnuncioDao().buscarMeusAnuncios(new Integer(id));
//			if(anuncios.size() > 0)
//				obj.addProperty("result", anuncios);
//			else
//				obj.addProperty("result", "Nenhum Anuncio");
//			
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Nenhum Anuncio");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
}