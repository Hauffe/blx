package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Contato;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class ContatoDao extends AbstractRepository<Contato> {
	
	@Override
	public Contato buscarPorId(long id) {
		return (Contato) this.entityManager.createQuery("FROM Contato WHERE codContato = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}