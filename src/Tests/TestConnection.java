package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import database.Database;

public class TestConnection {
	
	@Test
	public void connectionTest() {
		Connection con;
		try {
			con = Database.getConnection();
			assertNotNull(con); 
		} catch (SQLServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
