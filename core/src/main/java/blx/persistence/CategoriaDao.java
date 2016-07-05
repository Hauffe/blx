package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Categoria;

public class CategoriaDao extends PatternDAO<Categoria> {

	Session session;
	Transaction transaction;
	Query query;

	public static CategoriaDao instance = new CategoriaDao();

	public static CategoriaDao getInstance() {
		return instance;
	}

	@Override
	public Categoria buscarPorId(Integer id) {

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("FROM Categoria WHERE codCategoria = ?");

			
			query.setInteger(0, id);

			@SuppressWarnings("unchecked")
			List<Categoria> categorias = query.list();

			System.out.println("CATEGORIA FOUND: " + categorias.get(0));

			session.close();

			return categorias.get(0);

		} catch (Exception error) {
			error.printStackTrace();
			return null;

		}

	}

	@Override
	public boolean cadastrar(Categoria object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Categoria object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Categoria> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
