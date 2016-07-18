package com.brq.blx.infraestrutura;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractRepository<E> implements Repository<E>{

	protected Class<E> entityType;
	
	@PersistenceContext(unitName="DataSourceBLX")
	protected EntityManager entityManager;

	public AbstractRepository() {}

	@Override
	@Transactional
	public boolean cadastrar(E entity) {
		if (entity != null)
		{
			this.entityManager.merge(entity);
			return true;
		}	
		return false;			
	}

	@Override
	public boolean atualizar(E entity) {
		if(entity != null)
		{
			this.entityManager.merge(entity);
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<E> buscarTodos(String className) {
		return this.entityManager.createQuery("FROM " + className).getResultList();
	}
}