package com.brq.blx.persistence;

import java.util.List;

public abstract class PatternDAO<T> {

	public abstract boolean cadastrar(T object) throws Exception;
	
	public abstract boolean atualizar(T object)throws Exception;
	
	public abstract T buscarPorId(Integer id)throws Exception;
	
	public abstract List<T> buscarTodos() throws Exception;
	
	public abstract List<T> buscarComFiltro(String nome) throws Exception;
	
	public abstract boolean atualizarStatus(T object, Integer status) throws Exception;  
}