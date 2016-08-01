package 基于S2SH的分页.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import 基于S2SH的分页.model.User;
import 基于S2SH的分页.service.IUserService;

@Controller("userAction")
@Scope("prototype")
public class UserAction  extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = 4873155232777908243L;

	//User
	private User user;
	
	//具体逻辑服务
	private IUserService userService;
	
	public IUserService getUserService() {
		return userService;
	}

	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	
	@Override
	public User getModel() {
		if(user ==null)
				user = new User();
		return user;
	}
	


	/*获得用户列表*/
	public String  list(){
		ActionContext.getContext().put("pageUser", userService.findUser());
		return  SUCCESS ;
	}
	
	
}
