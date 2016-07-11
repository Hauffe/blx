package com.brq.blx.persistence;

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
	public boolean cadastrar(Imagem imagem) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(imagem);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(Imagem imagem) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(imagem);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Imagem> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Imagem");
		
		transaction = session.beginTransaction();
			
		@SuppressWarnings("unchecked")
		List<Imagem> listaImagens = query.list();
		
		session.close();
		return listaImagens;
	}

	@Override
	public List<Imagem> buscarComFiltro(String nome) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Imagem WHERE nmNome = ?");
		
		query.setString(0, nome);
		
		@SuppressWarnings("unchecked")
		List<Imagem> listaImagens = query.list();
		
		session.close();
		return listaImagens;
	}

	@Override
	public boolean atualizarStatus(Imagem object) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}