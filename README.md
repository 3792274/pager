#JavaEE简单的分页,3个示例，合并一个工程演示代码 <br>
###一、包括如下三个演示代码 
>1.一个使用 JDBC 、ThreadLocal、JSP、pager-taglib 分页示例 <br>
>2.Mybatis + pager-taglib 分页 <br>
>3.Struts2、Spring、Hibernate + pager-taglib 分页 
	 

###二、开发环境
* **Java：**   		java version "1.8.0_91"  、javac 1.8.0_91
*  **Tomcat**: 		apache-tomcat-8.0.35 
	* Servlet Spec:3.1   
	* JSP Spec：2.3    
	* EL Spec3.0
* **Eclipse:**   	 Version: Mars.2 Release (4.5.2)
* **Mysql:** 		 mysql-5.7.12-winx64
* **Maven:**  	     apache-maven-3.3.9
* **pager-taglib:**  2.0 
* **Mybatis:**       3.4.1
* **Struts2:**       
* **Hibernate:**     
* **Spring:**       


###三、数据库说明(详见工程 t_user.sql)
>1.Sql 数据库：

		String user = "root";
		String password = "12369";
		String url = "jdbc:mysql:///pager?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		
>2.建立存储过程(函数),插入数据

```java
BEGIN
	DECLARE i int;
	set i=1;
	
	WHILE i<10000 DO
		INSERT INTO t_user(username,nickname,password) values(CONCAT('user',i),CONCAT('nickname',i),CONCAT('password',i));
		set i = i+1;
		
  END WHILE;

END
```



###四、关于中文说明
* 完全是为了copy查找方便，可作为代码库<br>
* 程序就像积木，每个小功能独立解耦，遇到到大项目顺手捏来无需再读一遍代码，因为代码都很小。<br>


<br><br>
***

###版权原作者所有@ [视频:ivan] & [源代码:ivan]<br>
   ![头像](http://q4.qlogo.cn/g?b=qq&k=v81qK8OG0ZzFnolQ1l9Zag&s=140&t=1371265828&tp=webp)<br><br>
>1、[基于JSP的ThrealLocal分页实现](http://www.chuanke.com/2819950-160640.html)<br>
>2、[基于Servlet+MyBatis分页实现](http://www.chuanke.com/2819950-161141.html)<br>
>3、[基于Struts2+Spring+Hibernate分页](https://ke.qq.com/course/114323#term_id=100123791)







<br><br><br>
## 联系方式
qq:        3792274<br/>
email:     <3792274@qq.com><br/>

<br><br><br>
 
