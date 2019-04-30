package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	
	private static SqlSession sqlsession;	
	
	public synchronized static SqlSession getSqlSession() throws IOException
	{
		if(sqlsession==null)
		{
			SqlSessionUtil util=new SqlSessionUtil();
			sqlsession =util.createSqlSession();
			return sqlsession;
		}
		else {
		return sqlsession;
		}
	}
	
	   private  SqlSession createSqlSession() throws IOException
	   {
		   
			String resource = "SqlMapConfig.xml";
			// 得到配置文件流
			InputStream inputStream = Resources.getResourceAsStream(resource);

			// 创建会话工厂，传入mybatis的配置文件信息
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);

			// 通过工厂得到SqlSession
			SqlSession sqlSession = sqlSessionFactory.openSession();
			return sqlSession;
		   
	   }
	
	
	
	

}
