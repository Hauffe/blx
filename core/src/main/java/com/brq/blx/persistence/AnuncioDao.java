package com.brq.blx.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Anuncio;


public class AnuncioDao extends PatternDAO<Anuncio> {

	Session session;
	Transaction transaction;
	Query query;

	public static AnuncioDao instance = new AnuncioDao();

	public static AnuncioDao getInstance() {
		return instance;
	}

	@Override
	public Anuncio buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
	
		query = session.createQuery("FROM Anuncio WHERE codAnuncio = ?");
		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<Anuncio> anuncio = query.list();

		Anuncio anuncioFound = anuncio.get(0);
		
		System.out.println("ANUNCIO FOUND: " + anuncioFound);

		session.close();

		return anuncioFound;
	}

	@Override
	public boolean cadastrar(Anuncio anuncio) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();

		session.save(anuncio);

		System.out.println("Anuncio cadastrado: " + anuncio);

		session.flush();
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Anuncio> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Anuncio");
		
		@SuppressWarnings("unchecked")
		List<Anuncio> listaAnuncio= query.list();
		
		session.close();
		return listaAnuncio;
	}

	@Override
	public boolean atualizar(Anuncio anuncio) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(anuncio);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Anuncio> buscarComFiltro(String nome) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Anuncio WHERE nmNome = ?");
		
		query.setString(0, nome);
		
		@SuppressWarnings("unchecked")
		List<Anuncio> listaAnuncio = query.list();
		
		session.close();
		return listaAnuncio;
	}

	public List<Anuncio> buscarMeusAnuncios(Integer id) {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Anuncio WHERE blxUsuario = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Anuncio> listaAnuncio = query.list();
		
		session.close();
		return listaAnuncio;
	}

	@Override
	public boolean atualizarStatus(Anuncio anuncio) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.createQuery("FROM Anuncio WHERE codAnuncio = ?");
		query.setLong(0, anuncio.getCodAnuncio());

		@SuppressWarnings("unchecked")
		List<Anuncio> anuncios = query.list();

		Anuncio anuncioFound = anuncios.get(0);
		anuncioFound.setVlStatus(anuncio.getVlStatus());
		
		transaction = session.beginTransaction();
		session.update(anuncioFound);
		transaction.commit();
		session.close();
		
		return true;
	}
}