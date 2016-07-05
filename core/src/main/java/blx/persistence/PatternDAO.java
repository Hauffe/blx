package blx.persistence;

import java.util.List;

public abstract class PatternDAO<T> {

	public abstract boolean cadastrar(T object) throws Exception;
	
	public abstract boolean atualizar(T object)throws Exception;
	
	public abstract T buscarPorId(Integer id)throws Exception;
	
	public abstract List<T> buscarTodos() throws Exception;
	
}
