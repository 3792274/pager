package 基于JSP的ThreadLocal分页;

public interface IUserDAO {

	
	/**
	 * 得到所有用户并带有分页功能
	 */
	public Pager<User> list();
}
