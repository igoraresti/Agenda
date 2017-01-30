package database;

import java.util.List;

import modelo.Actor;

public interface DatabaseOperation {
	
	public void addActor(Actor actor);
	public void deleteActor(String actorId);
	public Actor getActor(String actorId);
	public List<Actor> getAllActors();
	public List<Actor> getAllActors(String last_name, String first_name);
	public Actor getActorById(String actor_id);

}
