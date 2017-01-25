package iaresti.Agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import modelo.Contacto;
import database.Database;
import database.DatabaseSQL;


public class App
{
	private static DatabaseSQL database = new DatabaseSQL();
	
	private static void menu(int option){
		int contactPosition;
		switch (option) {
		case 1:
			System.out.println("Intorduce nombre: ");
			String nombre = Keyboard.readString();
			System.out.println("Intorduce apellido: ");
			String apellido = Keyboard.readString();
			database.addContact(new Contacto(nombre, apellido));
			break;
		case 2:
			System.out.println("Intorduce posicion a borrar: ");
			contactPosition = Keyboard.readInt();
			database.deleteContact(contactPosition);
			break;
		case 3:
			System.out.println("Intorduce posicion a mostrar: ");
			contactPosition = Keyboard.readInt();
			Contacto contact = database.getContact(contactPosition);
			if(contact != null)
				System.out.println("Nombre: "+contact.getNombre()+" Apellido: "+contact.getApellido());
			break;
		case 4:
			for(Contacto person: database.getAllContacts())
				System.out.println("Nombre: "+person.getNombre()+" Apellido: "+person.getApellido());
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
        	System.out.println( "1-Añadir contacton\n2-Borrar contacto\n3-Mostrar Contacto"
        			+ "\n4-Mostrar todos los contactos\n5-Para salir pulsa -1\nElige opcion:" );
        	option = Keyboard.readInt();
        	menu(option);
        }
    }
}
