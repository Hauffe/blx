package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.TipoUsuario;

public class TipoUsuarioDao extends PatternDAO<TipoUsuario> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static TipoUsuarioDao instance = new TipoUsuarioDao();

	public static TipoUsuarioDao getInstance() {
		return instance;
	}

	@Override
	public TipoUsuario buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM TipoUsuario WHERE codTipoUsuario = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<TipoUsuario> user = query.list();
		
		System.out.println("TipoUsuario FOUND: " + user.get(0));
		
		session.close();
		
		return user.get(0);
	}
	
	@Override
	public boolean cadastrar(TipoUsuario tipoUsuario) throws Exception {
		return false;
	}

	@Override
	public boolean atualizar(TipoUsuario tipoUsuario) throws Exception {
		return false;
	}

	@Override
	public List<TipoUsuario> buscarTodos() throws Exception {
		return null;
	}
}