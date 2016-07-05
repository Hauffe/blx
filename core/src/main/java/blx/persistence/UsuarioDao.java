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

	public void atualizarUsuario(Usuario usuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(usuario);
		transaction.commit();
		session.close();
		// Transaction serve para dar commit ali, mas lembre-se, necessita
		// "chamá-lo" primeiramente. x

	}

	/* Esse método ele obrigatoriamente é do tipo "List", 
	 * pois é definido como padrão pelo Hibernate a query como List.
	 Ele busca o objeto a partir do parâmetro(id) passado na função, 
	 depois é recuperado no rest (com o método get) , na posição 0, pois 
	 só há um objeto com o mesmo id (um único elemento - posição 0) */


	@Override
	public boolean cadastrar(Usuario usuario) {
		
		try
		{
			// Abrir conxao com o banco de dados
			session = HibernateUtil.getSessionFactory().openSession();

			// ESSA OI SERVE PARA DAR COMMIT!!!@#!#$!@@%¨@#$%$@
			transaction = session.beginTransaction();

			// gravar os dados na tabela livro

			System.out.println("USUARIO ANTES SAVE: " + usuario);
			System.out.println("TIPO USUARIO ANTES SAVE: " + usuario.getBlxTipousuario().getCodTipousuario());

			/*
			 * session.save(usuario.getBlxTipousuario()); */
			session.save(usuario);
			System.out.println("USUARIO DEPOIS SAVE: " + usuario);
			System.out.println("TIPO USUARIO DEPOIS SAVE: " + usuario.getBlxTipousuario().getCodTipousuario());
			session.flush();
			transaction.commit();

			// Dar um commit no banco Mahou
			// Fechar conexao
			session.close();
			return  true;
			
		}catch (Exception error)
		{
			error.printStackTrace();
			return false;
		}
	
		  
	}

	@Override
	public boolean atualizar(Usuario usuario) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			
			session.update(usuario);
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
	public Usuario buscarPorId(Integer id) {
		try
		{
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("FROM Usuario WHERE codUsuario = ?");
			
			query.setInteger(0, id);
			
			@SuppressWarnings("unchecked")
			List<Usuario> user = query.list();
			
			System.out.println("USUARIO FOUND: " + user.get(0));
			
			session.close();
			
			return user.get(0);
			
		}catch(Exception error)
		{
			error.printStackTrace();
			return null;
		}
		
	}

	@Override
	public List<Usuario> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}



}
