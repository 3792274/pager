package 基于JSP的ThreadLocal分页;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBUtil {
	
	private static  String user = "root";
	private static  String password = "12369";
	private static  String url = "jdbc:mysql:///pager?useUnicode=true&characterEncoding=utf-8&useSSL=false";
	
	
	private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();
	
	private DBUtil(){}
 
 
	public static Connection getConn(){
		Connection connection = tl.get();
		
		try {
			if(connection == null || connection.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url,user,password);
				tl.set(connection);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} 
      
		System.out.println("获得connection对象的HashCode: "+connection.hashCode());
		return connection;
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
		}finally {
			tl.set(null);
		}
	}
	
	
}
