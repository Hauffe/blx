package blx.persistence;

import java.util.List;

public abstract class PatternDAO<T> {

	public abstract boolean cadastrar(T object);
	
	public abstract boolean atualizar(T object);
	
	public abstract T buscarPorId(Integer id);
	
	public abstract List<T> buscarTodos();
	
}
