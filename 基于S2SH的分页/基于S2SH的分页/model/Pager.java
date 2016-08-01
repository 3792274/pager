package 基于S2SH的分页.model;

import java.util.List;

public class Pager<T> {
	
	
	private int pageSize;//每页多少条，在DAO中设置
	private int pageOffset;//从第几条记录开始查，在DAO中设置
	
	private int pageIndex; //当前页
	
	private long totalRecord;//总记录数
	private long totalPage;//总页数
	
	private  List<T> datas; //详细数据
	
	
	
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
	public long getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
	
	
	
}
