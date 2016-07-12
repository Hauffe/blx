package com.brq.blx.persistence;

import java.util.List;

import javax.enterprise.context.Dependent;
import com.brq.blx.entity.Usuario;
import com.brq.blx.infraestrutura.AbstractRepository;

@Dependent
public class UsuarioDao extends AbstractRepository<Usuario> {
	
	public boolean autenticar (Usuario usuario) throws Exception {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = this.entityManager.createQuery("FROM Usuario WHERE vlLogin = ? AND vlSenha = ?").getResultList();
		this.entityManager.setProperty(usuario.getVlLogin(), 0);
		this.entityManager.setProperty(usuario.getVlSenha(), 1);
		
		if(usuarios.size() > 0 ) {
			return true;
		}
		
		return false;
	}
	
	
	public List<Usuario> buscarPorNome (String nome) throws Exception
	{
		List<Usuario> usuarios = this.entityManager.createQuery("FROM " + this.entityType + "WHERE nmNome = :nome", Usuario.class ).setParameter("nome", nome).getResultList();
	
		return usuarios;
	}

}