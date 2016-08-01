package 基于S2SH的分页.dao;

import 基于S2SH的分页.model.Pager;

public interface IBaseDAO<T> {
	
	
	public Pager<T>  find(String hql,Object ...  args)	;
	
	public Pager<T> find(String hql);
}
