package 基于S2SH的分页;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.apache.struts2.spring.StrutsSpringObjectFactory;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.filter.CharacterEncodingFilter;

public class Test {
	
	//Spring 监听器  
	ContextLoaderListener contextLoaderListener;
	
	
	//Spring 字符编码处理 监听器
	CharacterEncodingFilter characterEncodingFilter;
	
	
	//Spring中为Hibernate的Session提供的工具
	OpenSessionInViewFilter openSessionInViewFilter;

	
	//Struts2的过滤器
    StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter;
    
    //Struts2整合Spring ,Struts的Spring对象工厂
    StrutsSpringObjectFactory springObjectFactory;
    
    
    //Spring 中Apache DBCP 数据源
    BasicDataSource basicDataSource;
    
    
    //Spring 管理 Hibernate 的SessionFactoryBean
    LocalSessionFactoryBean localSessionFactoryBean;
    
    //Hibernate中Mysql 方言
    MySQL5Dialect mySQL5Dialect;
    MySQL5InnoDBDialect mySQL5InnoDBDialect; 
    
    
    //Spring管理 Hibernate 事务的 ,事务管理器
    HibernateTransactionManager hibernateTransactionManager;
    
    
    
    public static void main(String[] args) {
		String s = "select * from t_user ";
		String f= s.substring(0,s.indexOf("from"));  //select * 
		System.out.println(f);
	}
}












