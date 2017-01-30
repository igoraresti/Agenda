package database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MySQLConexionTest {
	
	private MySQLConexion msc;
	
	@Before
	public void init() throws Exception{
		msc = new MySQLConexion();
	}
	
	@Test
	public void should_connect_to_database(){
		assertNotNull(msc.getConexion());
	}

}
