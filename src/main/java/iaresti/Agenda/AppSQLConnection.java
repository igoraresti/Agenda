package iaresti.Agenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AppSQLConnection {

	public static void main(String[] args) {
		
		Connection con = null;
		final String url = "jdbc:mysql://localhost:3306/";
		final String agenda = "sakila";
		final String driver = "com.mysql.jdbc.Driver";
		final String username = "root";
		final String password = "admin";
		
		System.out.println("-------- MySQL JDBC Connection ------------");

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		try {

			con = DriverManager.getConnection(url+agenda,username, password);

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		
		if (con != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}

	}

}
