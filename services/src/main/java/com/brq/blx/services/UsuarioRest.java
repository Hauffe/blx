package com.brq.blx.services;

import java.math.BigDecimal;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.brq.blx.entity.Tipousuario;
import com.brq.blx.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
			//Usuario user = new Usuario(2, "nmNome", "vlEmail", "vlLogin", "vlRg", "vlSenha", null , null, null, aux);
			/*Usuario user = new Usuario(null, "12", "ex-23.com", 
					"3412a", "1", "321", BigDecimal.valueOf((long) 0), (long) 0);*/
			
			Usuario usuario = new Usuario("12", "ex-23.com", 
					"3412a", "1", "321", BigDecimal.valueOf((long) 0), (long) 0);
		
			new UsuarioDao().cadastrarUsuario(usuario);
			obj.addProperty("result", "Livro cadastrado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Livro nao cadastrado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
}
