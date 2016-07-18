package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Imagem;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class ImagemDao extends AbstractRepository<Imagem> {

	@Override
	public Imagem buscarPorId(long id) {
		return (Imagem) this.entityManager.createQuery("FROM Imagem WHERE codImagem = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}