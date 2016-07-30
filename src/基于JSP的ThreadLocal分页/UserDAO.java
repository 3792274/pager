package 基于JSP的ThreadLocal分页;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
	
	
	/**
	 * Dao 使用 JDBC可能使用到的 连接，编译语句，结果集等
	 */
	Connection connection=  null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	

	@Override
	public Pager<User> list() {
		
		int pageOffset = SystemContext.getPageOffset(); //查询起始位置(通过页面传递-pager.offset=656)
		int pageSize = SystemContext.getPageSize();   //固定死的每页显示多少条记录
		
		//查询指定数量的数据，组装List
		List<User> userList= getUserList(pageOffset, pageSize);
		
		//使用数据库查询的List组装PageUser
		Pager<User> pages = new Pager<User>();
		
		
		int totalRecord = getTotalRecord(); //总记录数
		
		pages.setPageOffset(pageOffset);  //设置数据记录起始位置
		pages.setPageSize(pageSize);      //设置数据记录大小
		pages.setDatas(userList);		  //设置具体数据内容
		
		pages.setTotalRecord(totalRecord);  //设置总的数据记录数量
		
		pages.setTotalPage((totalRecord-1)/pageSize+1);//总页数
		
		return pages;
	}
	
	
	

	/**
	 * 使用Mysql查询指定记录数 -LIMIT ?,?
	 * @param pageOffset     起始记录数
	 * @param pageSize       数据记录大小
	 * @return
	 */
	public List<User> getUserList(int pageOffset,int pageSize){
		List<User> userList = new ArrayList<>();
		try {
			connection = DBUtil.getConn();
			String sql = "select * from t_user LIMIT ?,?"; //Mysql分页查询，从第几条记录（offSize），查询多少条记录(pageSize)
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, pageOffset);
			preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				User tempUser = new User();
				tempUser.setId(resultSet.getInt("id"));
				tempUser.setUsername(resultSet.getString("username"));
				tempUser.setPassword(resultSet.getString("password"));
				tempUser.setNickname(resultSet.getString("nickname"));
				userList.add(tempUser); //
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		return userList;
	}
	
	
	
	/**
	 * 获取总记录数
	 */
	
	public int getTotalRecord(){
		int totalRecord = 0;
		try {
			connection = DBUtil.getConn();
			String sqlCount = "select count(*) from t_user"; //总记录数
			preparedStatement=connection.prepareStatement(sqlCount);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
			    totalRecord=resultSet.getInt(1); //总行数
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		return totalRecord;
	}
	
	
	
	
	
	
	
	//简单测试
	public static void main(String[] args) {
		Pager<User> datas = new UserDAO().list();
		System.out.println(datas.getDatas().size());
		
		List<User>  users= datas.getDatas();
		for (User user : users) {
			System.out.println(user.getNickname());
		}
	}
	
	

}


































