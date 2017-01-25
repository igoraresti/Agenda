package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Contacto;

public class DatabaseSQL {

private List<Contacto> listaContactos = new ArrayList<Contacto>();
private MySQLConexion msc;
	
	public DatabaseSQL(){
		msc = new MySQLConexion();
	}

	public void addContact(Contacto contact) {
		Connection con=msc.getConexion();
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

	public void deleteContact(int contactPosition){
		
	}

	public Contacto getContact(int contactPosition) {
		Connection con=msc.getConexion();
		// create a Statement from the connection
		 
		 return null;
		 
	}

	public List<Contacto> getAllContacts() {
		
		Connection con=msc.getConexion();
		// create a Statement from the connection
		
		
		 try {
			Statement stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery("SELECT * FROM CONTACTO");
			
			while (rs.next()){
				Contacto contact=new Contacto(rs.getString("nombre"),rs.getString("apellido"),rs.getInt("telefono"), rs.getString("sexo").charAt(0));
				listaContactos.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return listaContactos;
		
	}
}
