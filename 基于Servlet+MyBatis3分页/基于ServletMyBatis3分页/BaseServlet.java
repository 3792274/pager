package 基于ServletMyBatis3分页;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Method;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * servlet?method=user
 * 
 * @author Mr.TianShu
 *
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public final static String REDIRECTPATH="redirect:";

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String method = req.getParameter("method");
		
		try {
			Method m = this.getClass().getMethod(method, HttpServletRequest.class,HttpServletResponse.class);
//			String path = (String)m.invoke(this.getClass().newInstance(),req, resp);//路径
			String path = (String)m.invoke(this,req, resp); 
			
			if(path.startsWith(REDIRECTPATH)){
				String rp=path.substring(REDIRECTPATH.length());//redirect:user.jsp,最后跳转到user.jsp
				resp.sendRedirect(rp);
			}else{
			}
				req.getRequestDispatcher("/WEB-INF/"+path).forward(req, resp); //跳转到user.jsp
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		
//		super.service(req, resp);
	}
}

































