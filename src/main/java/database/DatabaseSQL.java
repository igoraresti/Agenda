package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.ReadWriteMap;
import modelo.Actor;

public class DatabaseSQL implements DatabaseOperation {

	private MySQLConexion msc;
	private static Map<String, Actor> actorMap = new HashMap<>();

	private static ReadWriteMap<String, Actor> rwActorLocker = new ReadWriteMap<String, Actor>(actorMap);

	private DatabaseSQL() {
		msc = new MySQLConexion();
	}
	
	private static class SingletonHolder {
		private static final DatabaseSQL INSTANCE = new DatabaseSQL();
	}

	public static DatabaseSQL getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public void addActor(Actor contact) {
		Connection con = msc.getConexion();
		// create a Statement from the connection
		Statement statement;
		try {
			statement = con.createStatement();
			statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// insert the data

	}

	public List<Actor> getAllActors(String last_name, String first_name) {
		Connection con = msc.getConexion();
		rwActorLocker.clear();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor Where last_name like '" + last_name
					+ "%' and first_name like '%" + first_name + "%'");

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor_id"),rs.getString("first_name"), rs.getString("last_name"));
				System.out.println("Mete actor:"+actor.getActorId());
				rwActorLocker.put(Integer.toString(actor.getActorId()), actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Actor>(rwActorLocker.getAll());

	}
	
	public Actor getActorById(String actor_id){
		Connection con = msc.getConexion();
		rwActorLocker.clear();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor WHERE actor_id like "+actor_id);

			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("actor_id"),rs.getString("first_name"), rs.getString("last_name"));
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
				Actor actor = new Actor(rs.getInt("actor_id"),rs.getString("first_name"), rs.getString("last_name"));
				rwActorLocker.put(Integer.toString(actor.getActorId()), actor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Actor>(rwActorLocker.getAll());
	}

	public void deleteActor(String actorId) {
		// TODO Auto-generated method stub
		
	}

	public Actor getActor(String actorId) {
		// TODO Auto-generated method stub
		return null;
	}

}