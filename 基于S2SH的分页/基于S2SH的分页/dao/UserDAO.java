package 基于S2SH的分页.dao;

import org.springframework.stereotype.Repository;

import 基于S2SH的分页.model.Pager;
import 基于S2SH的分页.model.User;

@Repository("userDAO")
public class UserDAO extends BaseDAO<User>implements IUserDAO {

}
