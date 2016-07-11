package com.brq.blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Alteracao;

public class AlteracaoDao extends PatternDAO<Alteracao> {
	
	Session session;
	Transaction transaction;
	Query query;

	public static AlteracaoDao instance = new AlteracaoDao();

	public static AlteracaoDao getInstance() {
		return instance;
	}
	
	@Override
	public Alteracao buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Alteracao WHERE codAlteracao = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Alteracao> alteracao = query.list();
		
		System.out.println("Alteracao FOUND: " + alteracao.get(0));
		
		session.close();
		
		return alteracao.get(0);
	}

	@Override
	public boolean cadastrar(Alteracao alteracao)  throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(alteracao);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(Alteracao alteracao) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(alteracao);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Alteracao> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Alteracao");
		
		@SuppressWarnings("unchecked")
		List<Alteracao> listaAlteracao = query.list();
		
		session.close();
		return listaAlteracao;
	}

	@Override
	public List<Alteracao> buscarComFiltro(String dtAlteracao) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Alteracao WHERE dtAlteracao = ?");
		
		query.setString(0, dtAlteracao);
		
		@SuppressWarnings("unchecked")
		List<Alteracao> listaAlteracao = query.list();
		
		session.close();
		return listaAlteracao;
	}

	@Override
	public boolean atualizarStatus(Alteracao alteracao) throws Exception {
		return false;
	}
}