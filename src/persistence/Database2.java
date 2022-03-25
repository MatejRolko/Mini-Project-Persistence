package persistence;

import java.sql.Connection;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class Database2 {
	public static Connection getConnection() throws SQLServerException {

		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setUser("CSC-CSD-S212_10407574");
		ds.setPassword("Password1!");
		ds.setServerName("hildur.ucn.dk");
		ds.setDatabaseName("CSC-CSD-S212_10407574");
		ds.setEncrypt(false);
		return ds.getConnection();
	}

}
