package database;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import modelo.Actor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class DatabaseTest 
{
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private Database database = new Database();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void shouldReturnIgorAresti(){
		Actor contact = database.getActor(0);
		assertEquals(contact.getFirstName()+contact.getLastName(), "Igor" + "Aresti");
	}
	
	@Test
	public void shouldNotReturnContactAndPrintErrorMessage(){
		database.getActor(-5);
		assertEquals("Esa posicion no tiene actor", outContent.toString());
	}
	
	@Test
	public void shouldAddContact(){
		Actor contact = new Actor("Pedro","Garcia");
		database.addActor(contact);
		assertEquals(contact,database.getActor(2));
	}
	
	@Test
	public void shouldDeleteContact(){
		database.deleteActor(1);;
		assertEquals(database.getActor(1), null);
	}
	
	@Test
	public void shouldNotDeleteContactAndPrintErrorMessage(){
		database.deleteActor(150);
		assertEquals("Esa posicion no tiene actor", outContent.toString());
	}
	
	@Test
	public void shouldReturnAllContacts(){
		database.addActor(new Actor("Pedro","Garcia"));
		List<Actor> listContacts = database.getAllActors();
		assertEquals(database.getActor(0), listContacts.get(0));
		assertEquals(database.getActor(1), listContacts.get(1));
	}
}
