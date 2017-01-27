package database;

import java.util.List;

import modelo.Actor;

public interface DatabaseOperation {
	
	public void addActor(Actor actor);
	public void deleteActor(int actorPosition);
	public Actor getActor(int actorPosition);
	public List<Actor> getAllActors();

}
