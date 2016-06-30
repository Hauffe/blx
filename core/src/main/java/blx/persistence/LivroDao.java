package blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import blx.entity.Livro;

public class LivroDao {

	Session session;
	Transaction transaction;
	Query query;
	
	public void cadastrar(Livro livro)throws Exception {
		//Abrir conxao com o banco de dados
		session = HibernateUtil.getSessionFactory().openSession();
		//Iniciar uma transacao com o banco
		transaction = session.beginTransaction();
		//gravar os dados na tabela livro
		session.save(livro);
		//Dar um commit no banco
		transaction.commit();
		//Fechar conexao
		session.close();		
	}
	
	public void atualizar(Livro livro)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(livro);
		transaction.commit();
		session.close();		
	}
	
	public void deletar(Livro livro)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(livro);
		transaction.commit();
		session.close();		
	}
	
	public List<Livro> listar()throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		//Select � pela classe da entidade
		//select * from tblivro order by titulo 
		query = session.createQuery("select l from Livro l order by l.titulo");
		List<Livro> lista = query.list();
		session.close();
		return lista;
	}
	

	
}
