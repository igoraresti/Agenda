package iaresti.Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import modelo.Actor;
import database.Database;
import database.DatabaseSQL;


public class App
{
	private static DatabaseSQL database = new DatabaseSQL();
	
	private static void menu(int option){
		int actorPosition;
		switch (option) {
		case 1:
			System.out.println("Intorduce nombre: ");
			String nombre = Keyboard.readString();
			System.out.println("Intorduce apellido: ");
			String apellido = Keyboard.readString();
			database.addActor(new Actor(nombre, apellido));
			break;
		case 2:
			System.out.println("Intorduce posicion a borrar: ");
			actorPosition = Keyboard.readInt();
			database.deleteActor(actorPosition);
			break;
		case 3:
			System.out.println("Intorduce posicion a mostrar: ");
			actorPosition = Keyboard.readInt();
			Actor actor = database.getActor(actorPosition);
			if(actor != null)
				System.out.println("Nombre: "+actor.getFirstName()+" Apellido: "+actor.getLastName());
			break;
		case 4:
			for(Actor person: database.getAllActors())
				System.out.println("Nombre: "+person.getFirstName()+" Apellido: "+person.getLastName());
			break;
		default:
			System.out.println("Opcion no encontrada");
			break;
		}
	}
	
    public static void main( String[] args )
    {
        int option=0;
       
        while(option != -1){
        	System.out.println();
        	System.out.println( "1-Añadir actor\n2-Borrar actor\n3-Mostrar actor"
        			+ "\n4-Mostrar todos los actores\n5-Para salir pulsa -1\nElige opcion:" );
        	option = Keyboard.readInt();
        	menu(option);
        }
    }
}
