package mybatis3.test;

import org.junit.Test;

import mybatis3.helper.SqlSessionHelper;

public class TestSqlSession {

	
	@Test
	public void testSqlSession(){
		System.out.println(SqlSessionHelper.getSqlSession());
	}
}
