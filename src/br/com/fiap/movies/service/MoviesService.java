package br.com.fiap.movies.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.movies.domain.Movie;

public class MoviesService {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("movies");
	EntityManager manager = factory.createEntityManager();
	
	public void insert(Movie movie) {
		manager.getTransaction().begin();
		manager.persist(movie);
		manager.getTransaction().commit();
	}
	
	public List<Movie> listAll(){
		String jpql = "SELECT p FROM Movie p";
		TypedQuery<Movie> query = manager.createQuery(jpql , Movie.class);
		return query.getResultList();
	}
	
	public void delete(Movie movie) {
		manager.getTransaction().begin();
		manager.remove(manager.merge(movie));
		manager.getTransaction().commit();
	}
	
	public void update(Movie movie) {
		manager.getTransaction().begin();
		manager.merge(movie);
		manager.getTransaction().commit();
	}

}
