package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Contato;

public class ContatoDao extends PatternDAO<Contato> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static ContatoDao instance = new ContatoDao();

	public static ContatoDao getInstance() {
		return instance;
	}
	
	public Contato buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Contato WHERE codContato = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Contato> contato = query.list();
		
		System.out.println("Contato FOUND: " + contato.get(0));
		
		session.close();
		
		return contato.get(0);
	}

	@Override
	public boolean cadastrar(Contato object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Contato object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Contato> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}