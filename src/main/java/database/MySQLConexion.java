package database;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;



public class MySQLConexion {

	private Connection con= null;
	final String url="jdbc:mysql://localhost:3306/";
	final String agenda="sakila";
	final String driver="com.mysql.jdbc.Driver";
	final String username="root";
	final String password="admin";
	
	 public MySQLConexion(){


	       try{
	    	   Class.forName(driver).newInstance();
	    	   
	           con=DriverManager.getConnection(url+agenda+"?user="+username+"&password="+password);
	           
	       }catch(Exception ex){
	           JOptionPane.showMessageDialog(null, ex);
	       }
	       
	   }
	
	public Connection getConexion(){
		return con;
	}
	
	public void desconectarBBDD(){
		con=null;
		if (con==null)
			System.out.println("La Base de Datos ha sido desconectada");
	}
	
}
