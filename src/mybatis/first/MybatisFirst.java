package mybatis.first;

import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisFirst {

	@Test
	public void findUserById() {

		String resource = "SqlMapConfig.xml";
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
			System.out.println(user.toString());
			
			sqlsession.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

        }
    }

	@Test
    public void findUserByName() throws IOException {
	    String resource = "SqlMapConfig.xml";
	    InputStream inputStream = Resources.getResourceAsStream(resource);
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	    SqlSession sqlSession = sqlSessionFactory.openSession();
	    List<User> usrlt = sqlSession.selectList("test.findUserByName","xiao");
        System.out.println(usrlt.toString());
        sqlSession.close();
    }

    @Test
    public void insertUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("xiaoqin1");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("qinhuangdao");
        sqlSession.insert("test.insertUser",user);
        System.out.println(user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUser",1);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setUsername("xiaqiang");
        user.setId(2);
        sqlSession.update("test.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
