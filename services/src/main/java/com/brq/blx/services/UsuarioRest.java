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
import com.brq.blx.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import blx.persistence.AnuncioDao;

@Path("/usuario")
public class UsuarioRest {

	@GET
	@Path("/cadastrar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar () 
	{
		JsonObject obj = new JsonObject();
		try{
			Usuario usuario = new Usuario(0, "12", "ex-23.com", "3412a", "1", "321", BigDecimal.valueOf((long) 0), (long) 0);
			
			Categoria vaiC = new Categoria((long) 3, "chá", "chá-verde", null, null);
			Contato lele = new Contato((long)3, "lala", "lele");
	
 
			Anuncio lala = new Anuncio("STAGS", new Date(), "Felipe", 50.,BigDecimal.valueOf((long) 0) , vaiC.getCodCategoria(), lele.getCodContato(), usuario.getCodUsuario());
			//Usuario user = new Usuario(2, "nmNome", "vlEmail", "vlLogin", "vlRg", "vlSenha", null , null, null, aux);
			/*Usuario user = new Usuario(null, "12", "ex-23.com", 
					"3412a", "1", "321", BigDecimal.valueOf((long) 0), (long) 0);*/
			
			/*Tipousuario lala = new Tipousuario(0, null);*/
			
			/*Usuario usuario = new Usuario("12", "ex-23.com", 
			"3412a", "1", "321", BigDecimal.valueOf((long) 0), lala);*/
			
		/*	new UsuarioDao().cadastrarUsuario(usuario);
			obj.addProperty("result", "Usuário cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário nao cadastrado!");
		}*/
			
			new AnuncioDao().cadastrarAnuncio(lala);
			obj.addProperty("result", "Lala cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Lala nao cadastrado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
}
