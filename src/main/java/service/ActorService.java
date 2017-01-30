package service;

import java.util.List;

import database.DatabaseSQL;
import modelo.Actor;

public class ActorService {
	private DatabaseSQL database = DatabaseSQL.getInstance();
	
	public List<Actor> getAllActors(String last_name, String first_name){
		return database.getAllActors(last_name.toUpperCase(), first_name.toUpperCase());
	}
	
	public Actor getActorByNameLastName(String last_name, String first_name){
		return database.getAllActors(last_name.toUpperCase(), first_name.toUpperCase()).get(0);
	}
	
	public Actor getActorById(String actor_id){
		return database.getActorById(actor_id);
	}
}
