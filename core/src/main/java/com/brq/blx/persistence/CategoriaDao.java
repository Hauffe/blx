
package com.brq.blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.Categoria;

public class CategoriaDao extends PatternDAO<Categoria> {

	Session session;
	Transaction transaction;
	Query query;

	public static CategoriaDao instance = new CategoriaDao();

	public static CategoriaDao getInstance() {
		return instance;
	}

	@Override
	public Categoria buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Categoria WHERE codCategoria = ?");

		query.setInteger(0, id);

		@SuppressWarnings("unchecked")
		List<Categoria> categorias = query.list();

		System.out.println("CATEGORIA FOUND: " + categorias.get(0));

		session.close();

		return categorias.get(0);
	}

	@Override
	public boolean cadastrar(Categoria categoria) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(categoria);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(Categoria categoria) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(categoria);
		transaction.commit();
		session.close();
		
		return true;
	}

	@Override
	public List<Categoria> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Categoria");
		
		@SuppressWarnings("unchecked")
		List<Categoria> listaCategoria = query.list();
		
		session.close();
		return listaCategoria;
	}

	@Override
	public List<Categoria> buscarComFiltro(String nome) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM Categoria WHERE nmNome= ?");
		
		query.setString(0, nome);
		
		@SuppressWarnings("unchecked")
		List<Categoria> listaCategoria = query.list();
		
		session.close();
		return listaCategoria;
	}

	@Override
	public boolean atualizarStatus(Categoria categoria, Integer status) throws Exception {
		return false;
	}
}