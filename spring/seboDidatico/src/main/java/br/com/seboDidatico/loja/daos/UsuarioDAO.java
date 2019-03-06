package br.com.seboDidatico.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.com.seboDidatico.loja.models.Usuario;

@Repository
public class UsuarioDAO implements UserDetailsService{

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario loadUserByUsername(String email) {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where email = :email", Usuario.class)
				.setParameter("email", email).getResultList();
		
		if(usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário com email: " + email + " não encontrado!");
		}
		
		return usuarios.get(0);
	}
	
}
