package com.brq.blx.persistence;

import java.util.List;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class AnuncioDao extends AbstractRepository<Anuncio> {

	public List<Anuncio> buscarMeusAnuncios(Integer id) {
		return this.entityManager.createQuery("FROM Anuncio WHERE blxUsuario.codUsuario = :id", Anuncio.class)
				.setParameter("id", id)
				.getResultList();
	}
	
	public List<Anuncio> buscarPorNome (String nome) throws Exception {
		List<Anuncio> anuncios = this.entityManager.createQuery("FROM Anuncio WHERE nmNome like :nome", Anuncio.class)
				.setParameter("nome", "%"+nome+"%")
				.getResultList();
			
		return anuncios;
	}
}