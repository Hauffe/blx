package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Anuncio;

public class AnuncioDao extends PatternDAO<Anuncio> {

	Session session;
	Transaction transaction;
	Query query;

	public static AnuncioDao instance = new AnuncioDao();

	public static AnuncioDao getInstance() {
		return instance;
	}

	@Override
	public Anuncio buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Anuncio WHERE codAnuncio = ?");

		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<Anuncio> anuncio = query.list();

		System.out.println("ANUNCIO FOUND: " + anuncio.get(0));

		session.close();

		return anuncio.get(0);
	}

	@Override
	public boolean cadastrar(Anuncio anuncio) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		session.save(anuncio);

		System.out.println("Anuncio cadastrado: " + anuncio);

		session.flush();
		transaction.commit();
		session.close();
		return true;

	}

	@Override
	public List<Anuncio> buscarTodos() throws Exception {
		return null;
	}

	@Override
	public boolean atualizar(Anuncio anuncio) throws Exception {
		return false;
	}
}