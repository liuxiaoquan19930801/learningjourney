package DaoTest;

import mybatis.DaoImpl.UserDaoImpl;
import mybatis.dao.UserDao;
import mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    @Test
    public void findUserById() throws Exception {
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);

        UserDao userDao = new UserDaoImpl(new SqlSessionFactoryBuilder().build(inputStream));
        User user = userDao.findUserById(3);
        System.out.println(user.toString());
    }

    @Test
    public void findUserByName() throws Exception{
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);

        UserDao userDao = new UserDaoImpl(new SqlSessionFactoryBuilder().build(inputStream));
        List<User> userList =userDao.findUserByName("xiao");
        System.out.println(userList.toString());
    }

    @Test
    public void insertUser() throws Exception{
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);

        UserDao userDao = new UserDaoImpl(new SqlSessionFactoryBuilder().build(inputStream));
        User user = new User();
        user.setUsername("tom");
        user.setSex("女");
        userDao.insertUser(user);
    }

    @Test
    public void updateUser() throws Exception{
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);

        UserDao userDao = new UserDaoImpl(new SqlSessionFactoryBuilder().build(inputStream));
        User user = new User();
        user.setId(2);
        user.setUsername("tom");
        user.setSex("男");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser() throws Exception{
        String source = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(source);

        UserDao userDao = new UserDaoImpl(new SqlSessionFactoryBuilder().build(inputStream));
        userDao.deleteUser(3);
    }
}
