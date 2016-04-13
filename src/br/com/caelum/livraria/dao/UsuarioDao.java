package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {
	
	@PostConstruct
	void aposCriacao(){
		System.out.println("[INFO] UsuarioDao foi criado");
	}
	
	//@Inject
	//private Banco banco;// = new Banco();
	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaPeloLogin(String login) {
		//return this.banco.buscaPeloNome(login);
		Usuario usuario = (Usuario) this.manager
				.createQuery("Select u from Usuario u where u.login =:pLogin")
				.setParameter("pLogin", login).getSingleResult();
		return usuario;
	}
	
}
