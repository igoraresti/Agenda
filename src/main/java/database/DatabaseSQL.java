package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import service.ReadWriteMap;
import modelo.Actor;
import modelo.Film;

public class DatabaseSQL implements DatabaseOperation {

	private MySQLConexion msc;
	private static Map<String, Actor> actorMap = new HashMap<>();

	private static ReadWriteMap<String, Actor> rwActorLocker = new ReadWriteMap<String, Actor>(
			actorMap);

	private DatabaseSQL() {
		msc = new MySQLConexion();
	}

	private static class SingletonHolder {
		private static final DatabaseSQL INSTANCE = new DatabaseSQL();
	}

	public static DatabaseSQL getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void addActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Cine");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		entitymanager.persist(actor);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

	public List<Actor> getAllActors(String first_name, String last_name) {
		Connection con = msc.getConexion();
		rwActorLocker.clear();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Actor Where last_name like '"
							+ last_name + "%' and first_name like '%"
							+ first_name + "%'");

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor_id"),
						rs.getString("first_name"), rs.getString("last_name"));
				rwActorLocker.put(Integer.toString(actor.getActorId()), actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Actor>(rwActorLocker.getAll());

	}

	public Actor getActorById(String actor_id) {
		Connection con = msc.getConexion();
		rwActorLocker.clear();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM Actor WHERE actor_id like "
							+ actor_id);

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor_id"),
						rs.getString("first_name"), rs.getString("last_name"));
				rwActorLocker.put(Integer.toString(actor.getActorId()), actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Actor>(rwActorLocker.getAll()).get(0);
	}

	public List<Actor> getAllActors() {
		Connection con = msc.getConexion();
		rwActorLocker.clear();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor");

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor_id"),
						rs.getString("first_name"), rs.getString("last_name"));
				rwActorLocker.put(Integer.toString(actor.getActorId()), actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Actor>(rwActorLocker.getAll());
	}

	public void deleteActor(String actorId) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Cine");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Actor actor = entitymanager.find(Actor.class, Integer.parseInt(actorId));
		entitymanager.remove(actor);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	public Actor getActor(String actorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateActor(Actor actor) {
		EntityManagerFactory emfactory = Persistence
				.createEntityManagerFactory("Cine");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Actor actor_to_update = entitymanager.find(Actor.class, actor.getActorId());

		if(actor.getFirstName()!=null)
			actor_to_update.setFirstName(actor.getFirstName());
		if(actor.getLastName()!=null)
			actor_to_update.setLastName(actor.getLastName());
		if(actor.getLastUpdate()!=null)
			actor_to_update.setLastUpdate(actor.getLastUpdate());
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	@Override
	public void addFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFilm(String filmId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Actor getFilm(String filmId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Film> getAllFilms() {
		// TODO Auto-generated method stub
		return null;
	}

}