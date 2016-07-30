package 基于ServletMyBatis3分页;

public interface IUserDAO {
	public Pager<User> getList(String name); //参数String name 查询条件在本例无用
}
