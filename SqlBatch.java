package sqlbatch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlBatch {
	Connection con;
	String sql,sql1,sql2,sql3;
	SqlBatch(){
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","");
			con.setAutoCommit(false);
			sql="insert into lecturer(name,location) values('jane','kiambu')";
			sql1="insert into lecturer(name,location) values('owino','kisumu')";
			sql2="insert into lecturer(name,location) values('moha','wajir')";
			sql3="insert into lecturer(name,location) values('tom','nairobi')";
			
			Statement st=con.createStatement();
			st.addBatch(sql);
			st.addBatch(sql1);
			st.addBatch(sql2);
			st.addBatch(sql3);
			
			st.executeBatch();
			con.commit();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new SqlBatch();
	}
}
