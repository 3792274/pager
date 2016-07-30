package 基于ServletMyBatis3分页;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private IUserDAO userDAO;
	
	public String list(HttpServletRequest request,HttpServletResponse response){
		userDAO = new UserDAO();
		Pager<User> pagerUser = userDAO.getList("");
		
		request.setAttribute("pagerUser", pagerUser);
		return "mybatis3/user.jsp";
	}
}
