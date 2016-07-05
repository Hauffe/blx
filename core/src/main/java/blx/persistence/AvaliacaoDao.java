package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Avaliacao;

public class AvaliacaoDao extends PatternDAO<Avaliacao> {

	Session session;
	Transaction transaction;
	Query query;
	
	public static AvaliacaoDao instance = new AvaliacaoDao();

	public static AvaliacaoDao getInstance() {
		return instance;
	}
	
	@Override
	public Avaliacao buscarPorId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Avaliacao WHERE codAvaliacao = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Avaliacao> avaliacao = query.list();
		
		System.out.println("CATEGORIA FOUND: " + avaliacao.get(0));
		
		session.close();
		
		return avaliacao.get(0);
	}

	@Override
	public boolean cadastrar(Avaliacao object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Avaliacao object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Avaliacao> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}