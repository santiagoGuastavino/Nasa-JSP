package factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String SERVER = "jdbc:mysql://sql10.freemysqlhosting.net:3306";
	private static final String BASE = "sql10586841";
	private static final String USER = "sql10586841";
	private static final String PASSWORD = "a6PyvNssu4";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException error) {
			error.printStackTrace();
			throw new Error(error);
		}
		
		String connectionString = SERVER + "/" + BASE;
		return DriverManager.getConnection(connectionString, USER, PASSWORD);
	}
}
