package com.brq.blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Contato;

public class ContatoDao extends PatternDAO<Contato> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static ContatoDao instance = new ContatoDao();

	public static ContatoDao getInstance() {
		return instance;
	}
	
	public Contato buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Contato WHERE codContato = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Contato> contato = query.list();
		
		System.out.println("Contato FOUND: " + contato.get(0));
		
		session.close();
		
		return contato.get(0);
	}

	@Override
	public boolean cadastrar(Contato contato) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(contato);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(Contato contato) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(contato);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Contato> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Contato");
		
		@SuppressWarnings("unchecked")
		List<Contato> listaContato = query.list();
		
		session.close();
		return listaContato;
	}

	@Override
	public List<Contato> buscarComFiltro(String telefoneFixo) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Contato WHERE vlTelefoneFixo= ?");
		
		query.setString(0, telefoneFixo);
		
		@SuppressWarnings("unchecked")
		List<Contato> listaContato = query.list();
		
		session.close();
		return listaContato;
	}

	@Override
	public boolean atualizarStatus(Contato contato) throws Exception {
		return false;
	}
}