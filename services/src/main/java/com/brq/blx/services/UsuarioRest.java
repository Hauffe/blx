package com.brq.blx.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
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
import com.brq.blx.persistence.ContatoDao;
import com.brq.blx.persistence.UsuarioDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Path("/usuario")
public class UsuarioRest {

	private Gson gson;

	@Inject
	private UsuarioDao usuarioDao;

	@Inject
	private ContatoDao contatoDao;

	public UsuarioRest() {
		super();
		this.gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Contato c) {
		try {
			// Cadastro do usuario
			Usuario u = c.getBlxUsuario();
			u.setVlStatus(1);
			usuarioDao.cadastrar(u);

			// Cadastro do contato
			contatoDao.cadastrar(c);

			return Response.ok(gson.toJson("Usuario cadastrado!")).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@POST
	@Path("/editar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editar(Usuario u) {
		try {
			usuarioDao.atualizar(u);
			return Response.ok(gson.toJson("Usuario atualizado!")).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@POST
	@Path("/autenticar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response autenticar(Usuario u) {
		try {
			Usuario usuario = usuarioDao.buscarPorLogin(u);
			if(usuario != null)
				return Response.ok(gson.toJson(usuario)).build();

			return Response.ok(gson.toJson("usuario nao existe")).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@GET
	@Path("/buscarPorId/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(@PathParam("id") String id) {
		try {
			Usuario usuario = usuarioDao.buscarPorId(new Integer(id));
			if (usuario != null)
				return Response.ok(gson.toJson(usuario)).build();

			return Response.ok(gson.toJson("Usuario nao encontrado")).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@GET
	@Path("/buscar/{busca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("busca") String busca) {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			usuarios = usuarioDao.buscarPorNome(busca);
			if (usuarios.size() > 0)
				return Response.ok(gson.toJson(usuarios)).build();

			return Response.ok(gson.toJson("Nenhum usuario")).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try {
			List<Usuario> usuarios = new ArrayList<>();
			usuarios = usuarioDao.buscarTodos("Usuario");
			
			if (usuarios.size() > 0)
				return Response.ok(gson.toJson(usuarios)).build();

			return Response.ok(gson.toJson("Nenhum usuario")).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}

	@POST
	@Path("/atualizarStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarStatus(Usuario u) {
		try {
			usuarioDao.atualizar(u);
			return Response.ok(gson.toJson("Status alterado!")).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
}
