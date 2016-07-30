package 基于ServletMyBatis3分页;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 获得请求以后，设置线程安全的两个变量
 * 1.读取web.xml配置的 pageSize    (要显示的记录数量)
 * 2.读取页面传递过来的  pager.offset  (从那条记录开始显示)
 * 3.将上面得到的两个信息写入SystemContext类，保证线程安全
 * @author Mr.TianShu
 *
 */
public class SystemContextFilter implements Filter {

	private int pageSize;  
	private int pageOffset;
	
	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		try {
			//通过XML获得配置，如果没获取到每页显示0条数据
			pageSize = Integer.parseInt(fConfig.getInitParameter("pageSize"));
		} catch (NumberFormatException e) {
			 System.out.println("从web.xml获取配置信息出错： "+e.getMessage());
			pageSize  = 1; 
		}
	}

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			 //获得页面传递需要的开始记录，如果没有获取的到就从0条开始。
			 String pagerOffset = request.getParameter("pager.offset");
			
			 pageOffset = (null!=pagerOffset&&!"".equals(pageOffset))?Integer.parseInt(pagerOffset):0;
			
			 //在线程安全相关SystemContext类中  设置显示多少条记录，从那条开始显示。
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(pageSize);
			
			chain.doFilter(request, response);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		 	pageOffset=0;
		}finally {
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
		}
		
	}
	
	

	
	@Override
	public void destroy() {
	}

}

