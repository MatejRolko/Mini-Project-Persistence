package persistence;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Database {
	public static Connection getConnection() throws SQLServerException {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("CSD-CSC-S212_10407574");
		ds.setPassword("Password1!");
		ds.setServerName("hildur.ucn.dk");
		ds.setDatabaseName("CSC-CSC-S212_10407574");
		ds.setEncrypt(false);
		return ds.getConnection();
	}

}
