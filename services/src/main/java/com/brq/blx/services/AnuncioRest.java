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

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Categoria;
import com.brq.blx.entity.Contato;
import com.brq.blx.entity.TipoUsuario;
import com.brq.blx.entity.Usuario;
import com.brq.blx.persistence.AlteracaoDao;
import com.brq.blx.persistence.AnuncioDao;
import com.brq.blx.persistence.CategoriaDao;
import com.brq.blx.persistence.ContatoDao;
import com.brq.blx.persistence.UsuarioDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Path("/anuncio")
public class AnuncioRest {
	
	private Gson gson;

	public AnuncioRest() {
		super();
		this.gson = new Gson();
	}

	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrar(Anuncio a) {
		try{
			a.setDtAnuncio(new Date());
			a.setVlStatus(1);
			
			AnuncioDao.getInstance().cadastrar(a);
			return Response.ok(gson.toJson("Anuncio cadastrado!")).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(gson.toJson("Erro ao acessar servidor")).build();
		}
		
	}
	
	@POST
	@Path("/alterar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response alterar(Anuncio a) {
		try{
			a.setDtAnuncio(new Date());
			a.setVlStatus(1);
			AnuncioDao.getInstance().atualizar(a);
			// cadastro de alteracao
			Alteracao al = new Alteracao();
			al.setDsDescricao(this.alteracoes(a));
			al.setDtAlteracao(new Date());
			al.setBlxAnuncio(a);
			AlteracaoDao.getInstance().cadastrar(al);
			return Response.ok(gson.toJson("Anúncio alterado!")).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		try{
			List<Anuncio> anuncios = new ArrayList<>();
			anuncios = AnuncioDao.getInstance().buscarTodos();
			if(anuncios.size() > 0) 
				return Response.ok(gson.toJson(anuncios)).build();
			else
				return Response.ok(gson.toJson("Nenhum Anuncio")).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	@GET
	@Path("/pegarAnuncio/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response anuncio(@PathParam("id") String id) {
		try{
			Anuncio a = AnuncioDao.getInstance().buscarPorId(new Integer(id));
			if(a != null)
				return Response.ok(gson.toJson(a)).build();
			else 
				return Response.ok(gson.toJson("anuncio não encontrado")).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
		
	}
	
	@GET
	@Path("/buscar/{busca}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("busca") String busca) {
		try{
			List<Anuncio> anuncios = new ArrayList<>();
			anuncios = new AnuncioDao().buscarComFiltro(busca);
			if(anuncios.size() > 0)
				return Response.ok(gson.toJson(anuncios)).build();
			else
				return Response.ok(gson.toJson("anuncio não encontrado")).build();
			
		} catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	@GET
	@Path("/meusAnuncios/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response meusAnuncios(@PathParam("id") String id) {
		try{
			List<Anuncio> anuncios = new ArrayList<>();
			anuncios = new AnuncioDao().buscarMeusAnuncios(new Integer(id));
			if(anuncios.size() > 0)
				return Response.ok(gson.toJson(anuncios)).build();
			else
				return Response.ok(gson.toJson("anuncio não encontrado")).build();
			
		} catch(Exception e){
			e.printStackTrace();
			return Response.ok(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	@POST
	@Path("/atualizarStatus")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizarStatus(Anuncio a) {
		try{
			AnuncioDao.getInstance().atualizarStatus(a);
			return Response.ok(gson.toJson("Status alterado!")).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(gson.toJson("Erro ao acessar servidor")).build();
		}
	}
	
	public String alteracoes(Anuncio a) {
		
		String an = "Nome: " + a.getNmNome() +
					", Descricao: " + a.getDsDescricao() +
					", Preco: " + a.getVlPreco() +
					", Status: " + a.getVlStatus() +
					", Nome categoria: " + a.getBlxCategoria().getNmNome() +
					", Descricao categoria: " + a.getBlxCategoria().getDsDescricao() + 
					", Contato telefone fixo: " + a.getBlxContato().getVlTelefoneFixo() +
					", Contato telefone movel: " + a.getBlxContato().getVlTelefoneMovel() +
					", Contato rua: " + a.getBlxContato().getBlxEndereco().getVlRua() +
					", Contato numero: " + a.getBlxContato().getBlxEndereco().getVlNumero() +
					", Contato cep: " + a.getBlxContato().getBlxEndereco().getVlCep() +
					", Contato cidade: " + a.getBlxContato().getBlxEndereco().getVlCidade() +
					", Contato estado: " + a.getBlxContato().getBlxEndereco().getVlUf();
		
		return an;
	}
	
}