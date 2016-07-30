#简单的分页 <br>
###1.一个使用 JDBC 、ThreadLocal、JSP、pager-taglib 的分页示例
	>分页原理、ThrealLocal用法，DAO编写、简单的Mysql存储过程<br>

###2.Mybatis的分页
	 >Mybatis的简单分页<br>



###3数据库说明
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
<br><br>


***

###版权所有@ [配套视频 主讲：ivan]
>1、[基于JSP的ThrealLocal分页实现](http://www.chuanke.com/2819950-160640.html)<br>
>2、[基于Servlet+MyBatis分页实现](http://www.chuanke.com/2819950-161141.html)<br>





## 联系方式
qq:        3792274<br/>
email:     <3792274@qq.com><br/>


 
