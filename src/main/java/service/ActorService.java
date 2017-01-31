package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import database.DatabaseSQL;
import modelo.Actor;

public class ActorService {
	private DatabaseSQL database = DatabaseSQL.getInstance();

	public List<Actor> getAllActors(String last_name, String first_name) {
		List<Actor> listaActorById= new ArrayList<Actor>();
		
		listaActorById.addAll(database.getAllActors(last_name.toUpperCase(),
				first_name.toUpperCase()));
		Collections.sort(listaActorById);
		return listaActorById;
	}
	
	

	public Actor getActorByNameLastName(String last_name, String first_name) {
		return database.getAllActors(last_name.toUpperCase(),
				first_name.toUpperCase()).get(0);
	}

	public Actor getActorById(String actor_id) {
		return database.getActorById(actor_id);
	}

	public void createActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(actor);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
