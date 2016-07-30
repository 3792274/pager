package 基于JSP的ThreadLocal分页;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {
 
	public static Connection getConn(){

		String user = "root";
		String password = "12369";
		String url = "jdbc:mysql:///pager?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		
		Connection conn =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
 
	
	//关闭资源
	public static void close(ResultSet rs, Statement st,Connection conn){
		try {
			if(rs!=null)
				rs.close();
			if(st!=null)
				st.close();
			if(conn!=null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
