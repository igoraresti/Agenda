package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Actor;

public class DatabaseSQL implements DatabaseOperation {

	private List<Actor> listaActores = new ArrayList<Actor>();
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
			statement.executeUpdate("INSERT INTO Customers "
					+ "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// insert the data

	}

	public void deleteActor(int contactPosition) {

	}

	public Actor getActor(int contactPosition) {

		return null;

	}

	public List<Actor> getAllActors() {

		Connection con = msc.getConexion();
		// create a Statement from the connection

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor");

			while (rs.next()) {
				Actor contact = new Actor(rs.getString("first_name"),
						rs.getString("last_name"));
				listaActores.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaActores;

	}

	public List<Actor> getAllActors(String last_name_filter) {

		Connection con = msc.getConexion();
		System.out.println("El filtro en database es: "+last_name_filter);
		// create a Statement from the connection

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Actor where last_name like '"+last_name_filter+"%'");

			while (rs.next()) {
				Actor contact = new Actor(rs.getString("first_name"),
						rs.getString("last_name"));
				listaActores.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaActores;

	}
}
