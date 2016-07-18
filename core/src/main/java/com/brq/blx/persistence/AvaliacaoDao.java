package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Avaliacao;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class AvaliacaoDao extends AbstractRepository<Avaliacao> {

	@Override
	public Avaliacao buscarPorId(long id) {
		return (Avaliacao) this.entityManager.createQuery("FROM Avaliacao WHERE codAvaliacao = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}