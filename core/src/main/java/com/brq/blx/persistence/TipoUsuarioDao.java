package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.TipoUsuario;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class TipoUsuarioDao extends AbstractRepository<TipoUsuario> {
	
	@Override
	public TipoUsuario buscarPorId(long id) {
		return (TipoUsuario) this.entityManager.createQuery("FROM TipoUsuario WHERE codTipoUsuario = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}