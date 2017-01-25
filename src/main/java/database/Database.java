package database;

import java.util.ArrayList;
import java.util.List;

import modelo.Contacto;

public class Database implements AgendaOperation{
	
	List<Contacto> listaContactos = new ArrayList<Contacto>();
	
	public Database(){
		listaContactos.add(new Contacto("Igor", "Aresti"));
		listaContactos.add(new Contacto("Jon Ander", "Gonzalez"));
	}

	public void addContact(Contacto contact) {
		if(listaContactos.size() >= 20)
			System.out.println("Agenda completa");
		else
			listaContactos.add(contact);
		
	}

	public void deleteContact(int contactPosition){
		try {
			listaContactos.remove(contactPosition);
		} catch (IndexOutOfBoundsException e) {
			System.out.print("Esa posicion no tiene contacto");
		}
	}

	public Contacto getContact(int contactPosition) {
		Contacto contact = null;
		try{
			contact = listaContactos.get(contactPosition);
		}catch (IndexOutOfBoundsException e) {
			System.out.print("Esa posicion no tiene contacto");
		}
		return contact;
	}

	public List<Contacto> getAllContacts() {
		return listaContactos;
	}
	

}
