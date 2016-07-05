package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Tipousuario;

public class TipoUsuarioDao extends PatternDAO<Tipousuario> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static TipoUsuarioDao instance = new TipoUsuarioDao();

	public static TipoUsuarioDao getInstance() {
		return instance;
	}

	@Override
	public Tipousuario buscarPorId(Integer id) throws Exception {
		
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("FROM Tipousuario WHERE codTipousuario = ?");
			
			
			@SuppressWarnings("unchecked")
			List<Tipousuario> user = query.list();
			
			System.out.println("TipoUsuario FOUND: " + user.get(0));
			
			session.close();
			
			return user.get(0);
			
		}catch (Exception error)
		{
			error.printStackTrace();
			return null;
		}
		
	}
	
	

	@Override
	public boolean cadastrar(Tipousuario object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Tipousuario object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tipousuario> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	





}
