package 基于ServletMyBatis3分页;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis3.helper.SqlSessionHelper;

/**
 * 通用操作
 * 对数据库的增删改查，按条件查询，带分页，不带分页的，全都可以放到这里。
 * @author Mr.TianShu
 *
 * @param <E>
 */
public class BaseDAO<E> {
	
	public Pager<E> getList(Class<E> clzz,Map<String, Object> params){
		return this.getList(clzz.getName()+"Mapper.getList", params);
	}
	
	
	public Pager<E> getList(String sqlId,Map<String , Object> params){
		
		Pager<E> pages = new Pager<>();
		
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		
		
		if(params!=null)
			params = new HashMap<String , Object>();
		
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffset);
		
		
		SqlSession session = SqlSessionHelper.getSqlSession();
		List<E> datas = session.selectList(sqlId,params);
		
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		
		int totalRecord = session.selectOne(sqlId+"_Count",pages);
		pages.setTotalRecord(totalRecord);
		
		return pages;
	}
	
	
	 
	 
}



































