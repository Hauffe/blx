package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Anuncio;

public class AnuncioDao extends PatternDAO<Anuncio>{

	Session session;
	Transaction transaction;
	Query query;
	
	public static AnuncioDao instance = new AnuncioDao();
	
	public static AnuncioDao getInstance() {
		return instance;
	}

	@Override
	public boolean cadastrar(Anuncio anuncio) {
		try
		{
			//Abrir conxao com o banco de dados
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			session.save(anuncio);
			
			System.out.println("Anuncio cadastrado: " + anuncio);
			
			session.flush();
			transaction.commit();
			session.close();
			return true;
			
		}catch(Exception error)
		{
			error.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean atualizar(Anuncio object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Anuncio buscarPorId(Integer id) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("FROM Anuncio WHERE codAnuncio = ?");
			
			query.setInteger(0, id);
			
			@SuppressWarnings("unchecked")
			List<Anuncio> anuncio = query.list();
			
			System.out.println("ANUNCIO FOUND: " + anuncio.get(0));
			
			session.close();
			
			return anuncio.get(0);
			
			
		}catch(Exception error)
		{
			error.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Anuncio> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}		
}