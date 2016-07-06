package blx.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Usuario;

public class UsuarioDao extends PatternDAO<Usuario> {

	Session session;
	Transaction transaction;
	Query query;
	
	public static UsuarioDao instance = new UsuarioDao();

	public static UsuarioDao getInstance() {
		return instance;
	}

	 /* 
	 * TRAVA AÍ, TRAVA AÍ! 
	 * Esse método ele obrigatoriamente é do tipo "List", 
	 * pois é definido como padrão pelo Hibernate a query como List.
	 * Ele busca o objeto a partir do parâmetro(id) passado na função, 
	 * depois é recuperado no rest (com o método get) , na posição 0, pois 
	 * só há um objeto com o mesmo id (um único elemento - posição 0) 
	 */

	@Override
	public boolean cadastrar(Usuario usuario) throws Exception {	
		// Abrir conxao com o banco de dados
		session = HibernateUtil.getSessionFactory().openSession();

		/* 
		* Transaction serve para dar commit.
		* É usado a session para dar "begin" na transaction porque
		* a mesma sessão que usou o banco precisa dar o commit
		* transaction = session.beginTransaction();
		*/

		// Gravar os dados na tabela BLX_USUARIO
		session.save(usuario);
		System.out.println("USUÁRIO SAVED: " + usuario);
		
		// Dar um commit no banco
		transaction.commit();

		// Fechar conexao
		session.close();
		return  true;	  
	}

	@Override
	public boolean atualizar(Usuario usuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(usuario);
		transaction.commit();
		session.close();
		
		return true;				
	}

	@Override
	public Usuario buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		/*
		 * A query está sem a parte "SELECT *", pois o hibernate já
		 * completa essa parte.
		 */
		query = session.createQuery("FROM Usuario WHERE codUsuario = ?");
		
		query.setInteger(0, id);
		
		/*
		 * Executa a query retornando sempre uma LIST.
		 */
		@SuppressWarnings("unchecked")
		List<Usuario> user = query.list();
		
		System.out.println("USUARIO FOUND: " + user.get(0));
		
		session.close();
		
		/*
		 * Retorna a 1º posição da lista, pois, nesse caso, 
		 * é certeza que retornará apenas um valor, ou seja,
		 * posição 0 da list.
		 */
		return user.get(0);					
	}

	@Override
	public List<Usuario> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Usuario");
		
		@SuppressWarnings("unchecked")
		List<Usuario> user = query.list();
		
		session.close();
		return user;
	}
}