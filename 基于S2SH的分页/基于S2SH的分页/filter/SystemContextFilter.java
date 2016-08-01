package 基于S2SH的分页.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import 基于S2SH的分页.model.SystemContext;

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
	
	
		
		//获取web.xml中配置的pageSize
		public void init(FilterConfig fConfig) throws ServletException {
 			pageSize = Integer.parseInt(fConfig.getInitParameter("pageSize"));
		}

	
	
	 //获取页面传递需要的开始记录，如果没有从第0条开始
	  private int getOffset(HttpServletRequest request){  
		  int pageOffset = 0;
	       try {  
				String pagerOffset = request.getParameter("pager.offset");
				pageOffset = ((null!=pagerOffset)&&(!"".equals(pagerOffset)))?Integer.parseInt(pagerOffset):0;
	       } catch (NumberFormatException ignore) {  
	    	   System.err.println(ignore.getMessage());
	    	   ignore.printStackTrace();
	       }  
	       return  pageOffset;  
	    }  
	     
	  
	  	//获得xml配置中的pageSize
	  private int getPagesize(HttpServletRequest request){  
	       return  this.pageSize; 
	    }   
	  
	    
	    
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  try {
			  
			   HttpServletRequest httpRequest = (HttpServletRequest)request;  
		       
			  //在线程安全相关SystemContext类中  设置显示多少条记录，从那条开始显示。
			  SystemContext.setPageOffset(getOffset(httpRequest));
			  SystemContext.setPageSize(getPagesize(httpRequest));
		 
			  //线程继续往下执行其他过滤器
			  chain.doFilter(request, response);
			  
			} finally {
				//清空线程绑定的分页信息
				SystemContext.removePageOffset();
				SystemContext.removePageSize();
			}
	}
	
	
	
    
	public SystemContextFilter() {
    }

	public void destroy() {
	}



}
