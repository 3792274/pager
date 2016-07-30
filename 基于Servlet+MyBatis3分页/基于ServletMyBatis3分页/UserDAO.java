package 基于ServletMyBatis3分页;

import java.util.HashMap;
import java.util.Map;

public class UserDAO extends BaseDAO<User> implements IUserDAO {

	@Override
	public Pager<User> getList(String name) {
		Map<String ,Object> params = new HashMap<>();
		if(name!=null)
			params.put("name", "%"+name+"%");
		
		Pager<User> uPager=getList(User.class, params);
		
		return uPager;
	}

}





























