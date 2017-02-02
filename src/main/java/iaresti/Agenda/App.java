package iaresti.Agenda;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import service.ActorService;
import modelo.Actor;
import database.DatabaseSQL;

public class App {
	private static ActorService actorService = new ActorService();

	private static void menu(int option) {
		String actor_id;
		switch (option) {
		case 1:
			Actor new_actor = new Actor();
			new_actor.setFirstName("Igor");
			new_actor.setLastName("Aresti");
			new_actor.setLastUpdate(new Timestamp(1000));
			actorService.createActor(new_actor);
			break;
		case 2:
			System.out.println("Intorduce posicion a borrar: ");
			actor_id = Keyboard.readString();
			actorService.deleteActor(actor_id);
			break;
		case 3:
			Actor actor = actorService.getActorByNameLastName("Igor", "");
			if (actor != null)
				System.out.println("Id: "+actor.getActorId()+" Nombre: " + actor.getFirstName()
						+ " Apellido: " + actor.getLastName());
			break;
		case 4:
			for (Actor person : actorService.getAllActors("", ""))
				System.out.println("Id: "+person.getActorId()+" Nombre: " + person.getFirstName()
						+ " Apellido: " + person.getLastName());
			break;
		case 5:
			Actor actor5 = new Actor("Moe","Aresti");
			actor5.setActorId(207);
			actorService.updateActor(actor5);
			break;
		case 6:
			for (Actor person : actorService.getAllActors("IGOR", "ARESTI"))
				System.out.println("Id: "+person.getActorId()+" Nombre: " + person.getFirstName()
						+ " Apellido: " + person.getLastName());
			break;
		default:
			System.out.println("Opcion no encontrada");
			break;
		}
	}

	public static void main(String[] args) {
		int option = 0;

		while (option != -1) {
			System.out.println();
			System.out
					.println("1-Añadir actor\n2-Borrar actor\n3-Mostrar un actor"
							+ "\n4-Mostrar todos los actores\n5-Actualizar Actor\n6-Mostrar todos los actore que se llamen Igor\n7-Para salir pulsa -1\nElige opcion:");
			option = Keyboard.readInt();
			menu(option);
		}
	}
}
