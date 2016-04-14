package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public List<Livro> livrosPeloTitulo(String titulo) {
		String sql = "select l from Livro l where l.titulo like :pTitulo";
		TypedQuery<Livro> query = this.manager
				.createQuery(sql, Livro.class);
		query.setParameter("pTitulo", "%" + titulo + "%");
		return query.getResultList();
	}
	
	
}
