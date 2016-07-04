package blx.persistence;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brq.blx.entity.Anuncio;
import com.brq.blx.entity.Usuario;




public class AnuncioDao {

		Session session;
		Transaction transaction;
		Query query;
		
		public void cadastrarAnuncio (Anuncio anuncio) throws Exception
		{
/*			  EntityManagerFactory factory = Persistence.
			          createEntityManagerFactory("usuarios");
			    EntityManager manager = factory.createEntityManager();

			    
			    manager.getTransaction().begin();    
			    manager.persist(usuario);
			    manager.getTransaction().commit();  

	
		    System.out.println("ID da tarefa: " + usuario.getCodUsuario());
			    manager.close();
*/			
			
			//Abrir conxao com o banco de dados
			session = HibernateUtil.getSessionFactory().openSession();
		
			//ESSA OI SERVE PARA DAR COMMIT!!!@#!#$!@@%¨@#$%$@
			transaction = session.beginTransaction();
			
			//gravar os dados na tabela livro
	
			System.out.println("É NÓIS2: " + anuncio);

/*				session.save(usuario.getBlxTipousuario());
*/				session.save(anuncio);
				System.out.println("É NÓIS: " + anuncio);
				session.flush();
				transaction.commit();
			
			
			
			
			//Dar um commit no banco Mahou
			//Fechar conexao
			session.close();	
		}
		
		public void atualizarUsuario (Usuario usuario) throws Exception
		{
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(usuario);
			transaction.commit();
			session.close();
			//Transaction serve para dar commit ali, mas lembre-se, necessita "chamá-lo" primeiramente.	x
			
		}
		
		
		public List<Usuario> listarUsuario()throws Exception
		{
			session = HibernateUtil.getSessionFactory().openSession();
			query = session.createQuery("select u from Usuario u order by u.nome");
			List<Usuario> lista = query.list();
			session.close();
			return lista;
		}

		
		
		
}
