package br.com.caelum.livraria.dao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.caelum.livraria.modelo.Usuario;

@Stateless
public class UsuarioDao {
	
	@PostConstruct
	void aposCriacao(){
		System.out.println("[INFO] UsuarioDao foi criado");
	}
	
	@Inject
	private Banco banco;// = new Banco();

	public Usuario buscaPeloLogin(String login) {
		return this.banco.buscaPeloNome(login);
	}
	
}
