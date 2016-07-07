package com.brq.blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Avaliacao;

public class AvaliacaoDao extends PatternDAO<Avaliacao> {

	Session session;
	Transaction transaction;
	Query query;
	
	public static AvaliacaoDao instance = new AvaliacaoDao();

	public static AvaliacaoDao getInstance() {
		return instance;
	}
	
	@Override
	public Avaliacao buscarPorId(Integer id){
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Avaliacao WHERE codAvaliacao = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Avaliacao> avaliacao = query.list();
		
		System.out.println("CATEGORIA FOUND: " + avaliacao.get(0));
		
		session.close();
		
		return avaliacao.get(0);
	}

	@Override
	public boolean cadastrar(Avaliacao avaliacao) throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(avaliacao);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(Avaliacao avaliacao)throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(avaliacao);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Avaliacao> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Avaliacao");
		
		@SuppressWarnings("unchecked")
		List<Avaliacao> listaAvaliacao = query.list();
		
		session.close();
		return listaAvaliacao;
	}

	@Override
	public List<Avaliacao> buscarComFiltro(String nota) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Avaliacao WHERE vlNota = ?");

		query.setString(0, nota);
		
		@SuppressWarnings("unchecked")
		List<Avaliacao> listaAvaliacao = query.list();
		session.close();
		return listaAvaliacao;
	}

	@Override
	public boolean atualizarStatus(Avaliacao avaliacao, Integer status) throws Exception {
		return false;
	}
	
	public List<Avaliacao> buscarAvaliacoes (Integer codAnuncio)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Avaliacao WHERE blxAnuncio.codAnuncio = ?");
			
		query.setInteger(0, codAnuncio);
		
		@SuppressWarnings("unchecked")
		List<Avaliacao> listaAvaliacoes = query.list();
		
		session.close();
		
		return listaAvaliacoes;
		
	}
}