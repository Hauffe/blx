package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Endereco;

public class EnderecoDao extends PatternDAO<Endereco> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static EnderecoDao instance = new EnderecoDao();

	public static EnderecoDao getInstance() {
		return instance;
	}
	
	@Override
	public Endereco buscarPorId(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Endereco WHERE codEndereco = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Endereco> endereco = query.list();
		
		System.out.println("Endereco FOUND: " + endereco.get(0));
		
		session.close();
		
		return endereco.get(0);
	}

	@Override
	public boolean cadastrar(Endereco endereco) throws Exception {
		return false;
	}

	@Override
	public boolean atualizar(Endereco endereco) throws Exception {
		return false;
	}

	@Override
	public List<Endereco> buscarTodos() throws Exception {
		return null;
	}
}