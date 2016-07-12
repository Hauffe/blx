package com.brq.blx.persistence;

import java.util.List;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Usuario;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class AnuncioDao extends AbstractRepository<Anuncio> {

	@SuppressWarnings("unchecked")
	public List<Anuncio> buscarMeusAnuncios(Integer id) {
		return this.entityManager.createQuery("FROM " + this.entityType + 
									   " WHERE blxUsuario.codUsuario = ?").getResultList();
	}
	
	
	
	public List<Anuncio> buscarPorNome (String nome) throws Exception
	{
		List<Anuncio> anuncios = this.entityManager.createQuery("FROM " + this.entityType + "WHERE nmNome = :nome" 
				, Anuncio.class).setParameter("nome", nome).getResultList();
			
		return anuncios;
	}
	
}