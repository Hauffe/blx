package com.brq.blx.infraestrutura;

import java.util.List;

public interface Repository<E> {
	
	public boolean cadastrar( E entity );
	
	public boolean atualizar( E entity );
	
	public List<E> buscarTodos ( String className );
	
	public E buscarPorId ( long id );
	
}