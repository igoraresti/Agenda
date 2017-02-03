package service;

import static org.junit.Assert.*;

import java.util.List;

import modelo.Actor;

import org.junit.Before;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class ActorServiceTest 
{
	private ActorService actorService;
	
	@Before
	public void setUp(){
		actorService = new ActorService();
	}
	@Test
	public void should_return_actor_by_name_last_name(){
		Actor actor = actorService.getActorByNameLastName("JON", "CHASE");
		assertEquals(actor.getFirstName()+actor.getLastName(), "JON" + "CHASE");
	}
	@Test
	public void should_return_actor_by_id(){
		Actor actor = actorService.getActorById("57");
		assertEquals(actor.getFirstName()+actor.getLastName(), "JUDE" + "CRUISE");
	}
	@Test
	public void should_return_all_actors_with_name_Penelope(){
		List<Actor> actors_Penelope = actorService.getAllActors("", "Penelope");
		for(Actor actor : actors_Penelope)
			assertEquals("PENELOPE", actor.getFirstName());
	}
	@Test
	public void should_return_all_actors_with_name_containing_Mi(){
		List<Actor> actors_Mi = actorService.getAllActors("mi", "");
		for(Actor actor : actors_Mi)
			assertTrue(actor.getFirstName().contains("MI"));
	}
	@Test
	public void should_persist_new_instance(){
		Actor actor = new Actor("Igor","Aresti");
		actorService.createActor(actor);
		assertEquals(actor.getFirstName(), actorService.getActorByNameLastName("Igor", "Aresti").getFirstName());
	}
	@Test
	public void should_persist_updated_instance(){
		Actor actor = actorService.getActorByNameLastName("Igor", "Aresti");
		actor.setFirstName("NewIgor");
		actorService.updateActor(actor);
	}
	@Test
	public void should_remove_all_igor_aresti(){
		for(Actor actor: actorService.getAllActors("Igor", "Aresti")){
			actorService.deleteActor(String.valueOf(actor.getActorId()));
		}
		assertNull(actorService.getActorByNameLastName("Igor", "Aresti"));
	}
}