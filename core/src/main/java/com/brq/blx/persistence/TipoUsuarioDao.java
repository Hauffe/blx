package com.brq.blx.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.brq.blx.entity.TipoUsuario;


public class TipoUsuarioDao extends PatternDAO<TipoUsuario> {
	
	Session session;
	Transaction transaction;
	Query query;
	
	public static TipoUsuarioDao instance = new TipoUsuarioDao();

	public static TipoUsuarioDao getInstance() {
		return instance;
	}

	@Override
	public TipoUsuario buscarPorId(Integer id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM TipoUsuario WHERE codTipoUsuario = ?");
		
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<TipoUsuario> user = query.list();
			
		session.close();
		
		return user.get(0);
	}
	
	@Override
	public boolean cadastrar(TipoUsuario tipoUsuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();

		transaction = session.beginTransaction();

		session.save(tipoUsuario);
	
		transaction.commit();
		
		session.close();
		return  true;
	}

	@Override
	public boolean atualizar(TipoUsuario tipoUsuario) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(tipoUsuario);
		transaction.commit();
		session.close();
		
		return true;	
		
	}

	@Override
	public List<TipoUsuario> buscarTodos() throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM TipoUsuario");
		
		@SuppressWarnings("unchecked")
		List<TipoUsuario> listaTipoUsuario = query.list();
		
		session.close();
		return listaTipoUsuario;
	}

	@Override
	public List<TipoUsuario> buscarComFiltro(String nome) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		query = session.createQuery("FROM TipoUsuario WHERE vlTipo = ?");
		
		query.setString(0, nome);
		
		@SuppressWarnings("unchecked")
		List<TipoUsuario> listaTipoUsuario = query.list();
		
		session.close();
		return listaTipoUsuario;
	}

	@Override
	public boolean atualizarStatus(TipoUsuario object, Integer status) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}