package 基于JSP的ThreadLocal分页;

/**
 * 线程安全的
 * @author Mr.TianShu
 */
public class SystemContext {

		//要查询数据记录的起始位置（数据库指针）
		private static ThreadLocal<Integer> pageOffset =  new ThreadLocal<Integer>();
		
		//每页大小
		private static ThreadLocal<Integer> pageSize  =  new ThreadLocal<Integer>();
		
		
		//当前页
		private static ThreadLocal<Integer> pageIndex  =  new ThreadLocal<Integer>();
		
	
	

	
	
	public static int getPageOffset(){
		return pageOffset.get();
	}
	public static void setPageOffset(int _pageOffset){
		  pageOffset.set(_pageOffset);
	}
	public static void removePageOffset(){
		pageOffset.remove();
	}
	
	
	
	
	public static int getPageSize(){
		return pageSize.get();
	}
	
	public static void setPageSize(int _pageSize){
		pageSize.set(_pageSize);
	}
	public static void removePageSize(){
		pageSize.remove();
	}
	
	
	
	
	
	
	public static int getPageIndex(){
		return pageIndex.get();
	}
	public static void setPageIndex(int _pageIndex){
		pageIndex.set(_pageIndex);
	}
	public static void removePageIndex(){
		 pageIndex.remove();
	}
	
	
	
}
