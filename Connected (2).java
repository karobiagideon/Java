package displaydata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connected {
String DB_URL="jdbc:mysql://localhost:3306/java";
String DRIVER="com.mysql.cj.jdbc.Driver";
String USERNAME="root";
String PASSWORD="";
String QUERY="SELECT * FROM login";
Statement st;

int rows = 0;
public int getdata() {
	try {
		Class.forName(DRIVER);
		Connection con =DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		st=con.createStatement();
		
		ResultSet rs=st.executeQuery(QUERY);
		while(rs.next()) {
			String id = rs.getString("id");
			String user = rs.getString("username");
			String pass = rs.getString("password");
			
			LoginDetails.tbmodel.addRow(new Object[] {id,user,pass});
			
			rows = rs.getRow();
		}
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rows;	
}
}
