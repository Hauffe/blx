package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Imagem;

public class ImagemDao extends PatternDAO<Imagem> {

	Session session;
	Transaction transaction;
	Query query;
	
	public static ImagemDao instance = new ImagemDao();

	public static ImagemDao getInstance() {
		return instance;
	}
	
	@Override
	public Imagem buscarPorId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Imagem WHERE codImagem = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Imagem> imagem = query.list();
		
		System.out.println("Imagem FOUND: " + imagem.get(0));
		
		session.close();
		
		return imagem.get(0);
	}

	@Override
	public boolean cadastrar(Imagem object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean atualizar(Imagem object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Imagem> buscarTodos() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
