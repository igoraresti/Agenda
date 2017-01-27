package database;

import java.util.ArrayList;
import java.util.List;

import modelo.Actor;

public class Database implements DatabaseOperation{
	
	List<Actor> listaActores = new ArrayList<Actor>();
	
	public Database(){
		listaActores.add(new Actor("Igor", "Aresti"));
		listaActores.add(new Actor("Jon Ander", "Gonzalez"));
	}

	public void addActor(Actor contact) {
		if(listaActores.size() >= 20)
			System.out.println("Agenda completa");
		else
			listaActores.add(contact);
		
	}

	public void deleteActor(int actorPosition){
		try {
			listaActores.remove(actorPosition);
		} catch (IndexOutOfBoundsException e) {
			System.out.print("Esa posicion no tiene actor");
		}
	}

	public Actor getActor(int actorPosition) {
		Actor actor = null;
		try{
			actor = listaActores.get(actorPosition);
		}catch (IndexOutOfBoundsException e) {
			System.out.print("Esa posicion no tiene actor");
		}
		return actor;
	}

	public List<Actor> getAllActors() {
		return listaActores;
	}
	

}
