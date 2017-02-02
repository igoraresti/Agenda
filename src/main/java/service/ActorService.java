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
		if(database.getAllActors(last_name.toUpperCase(),first_name.toUpperCase()).size()!=0){
			return database.getAllActors(last_name.toUpperCase(),first_name.toUpperCase()).get(0);
		}
		return null;
	}

	public Actor getActorById(String actor_id) {
		return database.getActorById(actor_id);
	}

	public void createActor(Actor actor) {
		actor.setFirstName(actor.getFirstName().toUpperCase());
		actor.setLastName(actor.getLastName().toUpperCase());
		database.addActor(actor);
	}
	
	public void updateActor(Actor actor) {
		actor.setFirstName(actor.getFirstName().toUpperCase());
		actor.setLastName(actor.getLastName().toUpperCase());
		database.updateActor(actor);
	}
	
	public void deleteActor(String actorId){
		database.deleteActor(actorId);
	}
}
