package grouproom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
	
	Connection con;
	String user;
	String pass;
	

	public ConnectionPool() {
		
	}
	
	public ConnectionPool(String username, String password) {
		this.user = username;
		this.pass = password;
		
	}
	
	public Connection connector() {
		
		String db_url = "jdbc:mysql://localhost:3306/classes";
		
		try {
			
			con = DriverManager.getConnection(db_url, user, pass);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
