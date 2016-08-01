package 基于S2SH的分页.model;

//线程安全的
public class SystemContext {

	// 要查询数据记录的起始位置（数据库指针）
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer>();

	// 每页大小
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

	
	public static int getPageOffset() {
		 Integer os = (Integer)pageOffset.get();  
         if(os== null){  
                return 0;  
         }  
         return os; 
	}

	public static void setPageOffset(int _pageOffset) {
		pageOffset.set(_pageOffset);
	}

	public static void removePageOffset() {
		pageOffset.remove();
	}
	
	

	public static int getPageSize() {
		  
        Integer ps = (Integer)pageSize.get();  
        if(ps== null){  
               return Integer.MAX_VALUE;  
        }  
        return ps;  
	}

	public static void setPageSize(int _pageSize) {
		pageSize.set(_pageSize);
	}

	public static void removePageSize() {
		pageSize.remove();
	}
 
	 
}
