package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import persistence.Database;

public class TestConnection {
	
	@Test
	public void connectionTest() {
		Connection con = Database.getInstance().getConnection();
		assertNotNull(con); 
	}

}
