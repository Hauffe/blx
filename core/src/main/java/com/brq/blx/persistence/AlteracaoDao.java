package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class AlteracaoDao extends AbstractRepository<Alteracao> {

	@Override
	public Alteracao buscarPorId(long id) {
		return (Alteracao) this.entityManager.createQuery("FROM Alteracao WHERE codAlteracao = :id")
											  .setParameter("id", id).getSingleResult();
	}
 
}