package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;

public class DatabaseSQL implements DatabaseOperation {

	private MySQLConexion msc;

	public DatabaseSQL() {
		msc = new MySQLConexion();
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

	public void deleteActor(int contactPosition) {

	}

	public List<Actor> getAllActors(String last_name, String first_name) {
		List<Actor> listaActores = new ArrayList<Actor>();
		Connection con = msc.getConexion();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor Where last_name like '" + last_name
					+ "%' and first_name like '%" + first_name + "%'");

			while (rs.next()) {
				Actor contact = new Actor(rs.getString("first_name"), rs.getString("last_name"));
				listaActores.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaActores;

	}
	
	public Actor getActorById(String actor_id){
		List<Actor> listaActores = new ArrayList<Actor>();
		Connection con = msc.getConexion();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor WHERE actor_id like "+actor_id);

			while (rs.next()) {
				Actor contact = new Actor(rs.getString("first_name"), rs.getString("last_name"));
				listaActores.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaActores.get(0);
	}

	public List<Actor> getAllActors() {
		// TODO Auto-generated method stub
		return null;
	}

	public Actor getActor(int actorPosition) {
		// TODO Auto-generated method stub
		return null;
	}
}
