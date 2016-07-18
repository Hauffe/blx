package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Endereco;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class EnderecoDao extends AbstractRepository<Endereco> {
	
	@Override
	public Endereco buscarPorId(long id) {
		return (Endereco) this.entityManager.createQuery("FROM Endereco WHERE codEndereco = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}