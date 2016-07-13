package com.brq.blx.persistence;

import java.util.List;

import javax.enterprise.context.Dependent;
import com.brq.blx.entity.Usuario;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class UsuarioDao extends AbstractRepository<Usuario> {
	
	public Usuario buscarPorLogin(Usuario usuario) throws Exception {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = this.entityManager.createQuery("FROM Usuario WHERE vlLogin = :login AND vlSenha = :senha")
			.setParameter("login", usuario.getVlLogin())
			.setParameter("senha", usuario.getVlSenha())
			.getResultList();
		
		if(usuarios.size() > 0 ) {
			return usuarios.get(0);
		}
		
		return null;
	}
	
	public List<Usuario> buscarPorNome (String nome) throws Exception {
		List<Usuario> usuarios = this.entityManager.createQuery("FROM Usuario WHERE nmNome like :nome", Usuario.class)
				.setParameter("nome", "%"+nome+"%")
				.getResultList();
	
		return usuarios;
	}
}