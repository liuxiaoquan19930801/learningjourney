package mybatis.first;

import java.io.InputStream;

import mybatis.po.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MybatisFirst {

	@Test
	public void findUserById() {
		
		String resource = "/SqlMapConfig.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources
					.getResourceAsStream(resource);
		
			// sessionFactory
			SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		
			// sqlSession
			SqlSession sqlsession = sqlsessionfactory.openSession();
			
			// db
			User user = sqlsession.selectOne("test.findUserById",1);
			System.out.println(user);
			
			//�ͷ���Դ
			sqlsession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}