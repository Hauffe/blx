package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Alteracao;

public class AlteracaoDao extends PatternDAO<Alteracao> {
	
	Session session;
	Transaction transaction;
	Query query;

	public static AlteracaoDao instance = new AlteracaoDao();

	public static AlteracaoDao getInstance() {
		return instance;
	}
	
	@Override
	public Alteracao buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Alteracao WHERE codAlteracao = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Alteracao> alteracao = query.list();
		
		System.out.println("Alteracao FOUND: " + alteracao.get(0));
		
		session.close();
		
		return alteracao.get(0);
	}

	@Override
	public boolean cadastrar(Alteracao object)  throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Alteracao object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Alteracao> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}