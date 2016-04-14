package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
//@Interceptors({LogInterceptador.class})
public class AutorDao {
	
	@PostConstruct
	void aposCriacao(){
		System.out.println("[INFO] UsuarioDao foi criado");
	}
	
	//@Inject
	//private Banco banco;// = new Banco();
	@PersistenceContext
	private EntityManager manager;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor){
		System.out.println("[INFO] Salvando o Autor " + autor.getNome());
		
	/*	try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		//banco.save(autor);
		manager.persist(autor);
		
		System.out.println("[INFO] Salvou o Autor " + autor.getNome());
	}
	
	
	public List<Autor> todosAutores() {
		//return banco.listaAutores();
		return manager.createQuery("Select a from Autor a", Autor.class)
				.getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		//Autor autor = this.banco.buscaPelaId(autorId);
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
