package 基于S2SH的分页.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import 基于S2SH的分页.dao.IUserDAO;
import 基于S2SH的分页.model.Pager;
import 基于S2SH的分页.model.User;

@Service("userService")
public class UserService implements IUserService {

	private IUserDAO userDAO;
	
	@Resource
	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}


	@Override
	public Pager<User> findUser() {
		String hql = "from User u";
		System.out.println(hql);
		return userDAO.find(hql);
	}

}
