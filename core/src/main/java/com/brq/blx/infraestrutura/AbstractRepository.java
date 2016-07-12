package com.brq.blx.infraestrutura;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractRepository<E> implements Repository<E>{

	protected Class<E> entityType;
	
	@PersistenceContext(unitName="DataSourceBLX")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractRepository() {
		ParameterizedType  parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityType = ( Class<E> ) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
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
	public List<E> buscarTodos() {
		return this.entityManager.createQuery("FROM " + this.entityType).getResultList();
	}

	@Override
	public E buscarPorId(long id) {
		return this.entityManager.find(this.entityType, id);	
	}

	
	
	
}