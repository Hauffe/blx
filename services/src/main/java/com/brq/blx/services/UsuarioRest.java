package com.brq.blx.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.brq.blx.entity.Contato;
import com.brq.blx.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.brq.blx.persistence.ContatoDao;
import com.brq.blx.persistence.UsuarioDao;

@Path("/usuario")
public class UsuarioRest {
	
	private Gson gson;
	
	public UsuarioRest() {
		super();
		this.gson = new Gson();
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Contato c) {
		try {
			//Cadastro do usuario
			Usuario u = c.getBlxUsuario();
			u.setVlStatus(1);
			UsuarioDao.getInstance().cadastrar(u);
			
			//Cadastro do contato
			ContatoDao.getInstance().cadastrar(c);
			
			return Response.ok(gson.toJson("Usuario cadastrado!")).build();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Usuario nao cadastrado!")).build();
		}
	}
	
	@POST
	@Path("/editar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Usuario u) {
		JsonObject obj = new JsonObject();
		try{
//			new UsuarioDao().atualizar(u);
			UsuarioDao.getInstance().atualizar(u);
			obj.addProperty("result", "Usuário atualizado!");
		}catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não atualizado!");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@POST
	@Path("/autenticar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(Usuario u) {
		try{
			if(UsuarioDao.getInstance().autenticar(u)) {
				return Response.ok(gson.toJson("autenticado")).build();
			} 
			return Response.ok(gson.toJson("nautenticado")).build();
		} catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	@GET
	@Path("/buscarPorId/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") String id) {
		JsonObject obj = new JsonObject();
		try{
			Usuario usuario = new UsuarioDao().buscarPorId(new Integer(id));
			if(usuario != null) {
				obj.addProperty("result", new Gson().toJson(usuario));
			} else {
				obj.addProperty("result", "Usuário não encontrado");
			}
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não encontrado");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
	
	@GET
	@Path("/buscar/{busca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("busca") String busca) {
		JsonObject obj = new JsonObject();
		try{
//			List<Usuario> usuarios = new ArrayList<>();
//			usuarios = new UsuarioDao().buscarUsuarios(busca);
//			if(usuarios.size() > 0) {
//				obj.addProperty("result", new Gson().toJson(usuarios));
//			} else {
//				obj.addProperty("result", "Usuário não encontrado");
//			}
		} catch(Exception e){
			e.printStackTrace();
			obj.addProperty("result", "Usuário não encontrado");
		}
		return Response.ok(new Gson().toJson(obj)).build();
	}
}
