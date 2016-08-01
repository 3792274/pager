package 基于S2SH的分页.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import 基于S2SH的分页.model.Pager;
import 基于S2SH的分页.model.SystemContext;

public class BaseDAO<T> implements IBaseDAO<T> {
	
	//通过Spring自动注入Hibernate SessionFactory
	private SessionFactory SessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		SessionFactory = sessionFactory;
	}

	
	public SessionFactory getSessionFactory() {
		return SessionFactory;
	}


	//获得session
	protected Session getSession(){
		return SessionFactory.getCurrentSession();
	}
	
	

	@Override
	public Pager<T> find(String hql, Object... args) {
		Pager<T> pages = new Pager<>();
		
		
		int pageOffset = SystemContext.getPageOffset();
		int pageSize = SystemContext.getPageSize();
		
		Query listQuery = this.getSession().createQuery(hql);
		Query countQuery = this.getSession().createQuery(getCountHsql(hql));
		
		//填充查询条件
		if(args !=null){
			int index = 0;
			for(Object arg:args){
				listQuery.setParameter(index, arg);
				countQuery.setParameter(index, arg);
				index++;
			}
		}
		
		//获得相关查询的总数据量
		long totalRecord = (Long)countQuery.uniqueResult();
		
		//查询具体数据
		listQuery.setFirstResult(pageOffset);
		listQuery.setMaxResults(pageSize);
		List<T> datas = listQuery.list();
		
		//封装pages页面对象
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		pages.setTotalRecord(totalRecord);
		
		return pages;
	}

	@Override
	public Pager<T> find(String hql) {
		return this.find(hql, null);
	}
	
	
	/**
	 * 截取HQL,获得查询count(*)
	 * @param hql
	 * @return
	 */
	private String getCountHsql(String hql){
		String f = hql.substring(0,hql.indexOf("from"));
		
		if("".equals(f)){
			hql = "select count(*) "+hql;
		}else {
			hql = hql.replace(f, "select count(*) ");
		}
		
		hql = hql.replace("feth", " ");
		return hql;
		 
	}

}

























