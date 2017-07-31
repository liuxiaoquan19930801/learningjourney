package mybatis.first;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class MybatisFirst {

	@Test
	public void findUserById() {

		String resource = "config/SqlMapConfig.xml";
		InputStream inputStream = null;
		File file = new File(resource);
		System.out.println(file.exists());
		try {
			inputStream = Resources
					.getResourceAsStream(resource);
		
			// sessionFactory
			SqlSessionFactory sqlsessionfactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
		
			// sqlSession
			SqlSession sqlsession = sqlsessionfactory.openSession();
			
			// db
			User user = sqlsession.selectOne("test.findUserById",3);
			System.out.println(user.toString());
			
			sqlsession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
