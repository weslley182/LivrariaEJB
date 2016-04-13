package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {
	
	//@Inject
	//private Banco banco;// = new Banco();
	@PersistenceContext
    private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
		//banco.save(livro);
	}
	
	public List<Livro> todosLivros() {
		//return banco.listaLivros();
		return manager.createQuery("Select l from Livro l", Livro.class)
				.getResultList();
	}
	
}
