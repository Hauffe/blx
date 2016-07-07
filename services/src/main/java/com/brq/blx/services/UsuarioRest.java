package com.brq.blx.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Categoria;
import com.brq.blx.entity.Contato;
import com.brq.blx.entity.Usuario;
import com.brq.blx.persistence.AnuncioDao;
import com.brq.blx.persistence.CategoriaDao;
import com.brq.blx.persistence.UsuarioDao;
import com.brq.blx.utility.HibernateProxyTypeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@Path("/usuario")
public class UsuarioRest {

	@GET
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar () {
		JsonObject obj = new JsonObject();
		
		try{
			Usuario usuario = UsuarioDao.getInstance().buscarPorId(11);
			
			new UsuarioDao().atualizarStatus(usuario, 0);
			obj.addProperty("result", "Rei cadastrado!");
			
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Rei nao cadastrado!");
		}
		
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/cadastrarAnuncio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarAnuncio() {
		JsonObject obj = new JsonObject();
		
		try{
			Usuario usuario = UsuarioDao.getInstance().buscarPorId(35);
			
			Categoria categoria = CategoriaDao.getInstance().buscarPorId(0);
			Contato contato = new Contato((long) 0, "lala", "lele", usuario);
			
			//Anuncio anuncio = new Anuncio((long) 0, "descricao dois", new Date(), "ALEX ANÚNCIO", 50.,BigDecimal.valueOf(0), categoria, contato, usuario );
			
			//AnuncioDao.getInstance().cadastrar(anuncio);
			obj.addProperty("result", "Anuncio cadastrado!");
			
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Anuncio não cadastrado!");
		}
		
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/lala")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarAnuncioJSON() {
		JsonObject obj = new JsonObject();
		
		try{
			GsonBuilder b = new GsonBuilder();
			b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);

			Gson gson = b.create();
			
			Anuncio anuncio = AnuncioDao.getInstance().buscarPorId(15);
			obj.addProperty("result",  gson.toJson(anuncio));

			
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Anuncio não cadastrado!");
		}
		
		return Response.ok(new Gson().toJson(obj)).build();
	}
}