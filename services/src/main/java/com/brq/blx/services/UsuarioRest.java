package com.brq.blx.services;

import java.math.BigDecimal;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Categoria;
import com.brq.blx.entity.Contato;
import com.brq.blx.entity.Tipousuario;
import com.brq.blx.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import blx.persistence.AnuncioDao;
import blx.persistence.CategoriaDao;
import blx.persistence.TipoUsuarioDao;
import blx.persistence.UsuarioDao;

@Path("/usuario")
public class UsuarioRest {

	@GET
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar () 
	{
		JsonObject obj = new JsonObject();
		try{
			Tipousuario tipoUsuario = new TipoUsuarioDao().buscarPorId(1);
			
			Usuario usuario = new Usuario((long) 0, "RODRIGO SENPAI", "rodrigo@coti.com.brq","rodrigo_master", "898712-212", "1232", BigDecimal.valueOf((long) 0), null, null, tipoUsuario); 
			
			new UsuarioDao().cadastrar(usuario);
			obj.addProperty("result", "Lala cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Lala nao cadastrado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/cadastrarAnuncio")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarAnuncio()
	{
		JsonObject obj = new JsonObject();
		try{
			Usuario usuario = UsuarioDao.getInstance().buscarPorId(35);
			
			Categoria categoria = CategoriaDao.getInstance().buscarPorId(0);
			Contato contato = new Contato((long) 0, "lala", "lele", usuario);
			
			Anuncio anuncio = new Anuncio((long) 0, "descricao", new Date(), "GIOVANI ANÚNCIO", 50.,BigDecimal.valueOf(0), categoria, contato, usuario );
			
			AnuncioDao.getInstance().cadastrar(anuncio);
			obj.addProperty("result", "Anuncio cadastrado!");
			
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Anuncio nao cadastrado!");
		}
		
		return Response.ok(new Gson().toJson(obj)).build();
	}
}
