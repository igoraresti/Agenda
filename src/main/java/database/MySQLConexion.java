package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MySQLConexion {

	private Connection con = null;
	final String url = "jdbc:mysql://localhost:3306/";
	final String agenda = "sakila";
	final String driver = "com.mysql.jdbc.Driver";
	final String username = "root";
	final String password = "admin";

	public MySQLConexion() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}

		try {

			con = DriverManager.getConnection(url+agenda,username, password);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}

	}

	public Connection getConexion() {
		return con;
	}

	public void desconectarBBDD() {
		con = null;
		if (con == null)
			System.out.println("La Base de Datos ha sido desconectada");
	}

}
