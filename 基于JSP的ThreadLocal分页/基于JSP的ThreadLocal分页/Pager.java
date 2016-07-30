package 基于JSP的ThreadLocal分页;

import java.util.List;

/**
 * 分页数据
 * @author Mr.TianShu
 */
public class Pager<E> {
	
	
	private int pageSize;//每页多少条，在DAO中设置
	private int pageOffset;//从第几条记录开始查，在DAO中设置
	
	private int pageIndex; //当前页
	
	private int totalRecord;//总记录数
	private int totalPage;//总页数
	
	private  List<E> datas; //详细数据
	
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageOffset() {
		return pageOffset;
	}
	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<E> getDatas() {
		return datas;
	}
	public void setDatas(List<E> datas) {
		this.datas = datas;
	}
	
	
	
	
}
