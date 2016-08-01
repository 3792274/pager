package 基于S2SH的分页.service;

import 基于S2SH的分页.model.Pager;
import 基于S2SH的分页.model.User;

public interface IUserService {

	public Pager<User> findUser();
}
