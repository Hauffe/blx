
package com.brq.blx.persistence;

import javax.enterprise.context.Dependent;

import com.brq.blx.entity.Alteracao;
import com.brq.blx.entity.Categoria;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class CategoriaDao extends AbstractRepository<Categoria> {

	@Override
	public Categoria buscarPorId(long id) {
		return (Categoria) this.entityManager.createQuery("FROM Categoria WHERE codCategoria = :id")
											  .setParameter("id", id).getSingleResult();
	}
	
}