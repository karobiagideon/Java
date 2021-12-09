package displaydata;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import displaydata.Connected;

@SuppressWarnings("serial")
public class Connected extends LoginDetails implements Serializable{
private static String DB_URL="jdbc:mysql://localhost:3306/java";
private static String DRIVER="com.mysql.cj.jdbc.Driver";
private static String USERNAME="root";
private static String PASSWORD="";
private static String QUERY="SELECT * FROM login";
private static Statement st;

static int rows = 0;
public static int getdata() {
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
		System.out.println("Driver error");
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rows;	
}
public static int delete(int id) {
	// TODO Auto-generated method stub
	int flag = 0;
	try {
		Class.forName(DRIVER);
		Connection con =DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		
		Statement st =con.createStatement();
		int del =st.executeUpdate("delete from login where id = '"+id+"'   ");
		flag = del;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return flag;
}
public static int doupdate(String getid, String getuser, String getpass) {
	// TODO Auto-generated method stub
	int flag = 0;
	try {
		Class.forName(DRIVER);
		Connection con =DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		
		Statement st =con.createStatement();
		int del =st.executeUpdate("update  login set id='"+getid+"',username='"+getuser+"',password ='"+getpass+"'where id = '"+getid+"'   ");
		flag = del;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return flag;
}
}
