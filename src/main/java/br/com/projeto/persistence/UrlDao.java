package br.com.projeto.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.projeto.entity.Url;

public class UrlDao {

	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;
	
	public UrlDao() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("projShort");
		this.entityManager = this.entityManagerFactory.createEntityManager();

	}
	
	public void save(Url url){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(url);
		this.entityManager.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Url> findAll(){
 
		return this.entityManager.createQuery("SELECT u FROM Url as u").getResultList();
	}
 
	public Url find(Integer codigo){
 
		return this.entityManager.find(Url.class, codigo);
	}

	
	public void delete(Integer cod) {
		Url u = this.find(cod);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(u);
		this.entityManager.getTransaction().commit();
		
	}
	
	public void update(Url url){
		 
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(url);
		this.entityManager.getTransaction().commit();
	}

}
