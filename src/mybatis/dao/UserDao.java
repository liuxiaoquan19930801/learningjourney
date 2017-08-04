package mybatis.dao;

import mybatis.po.User;

import java.util.List;

public interface UserDao {
    //根据id查询用户数据
    public User findUserById(int id) throws Exception;

    //根据名称模糊查询数据
    public List<User> findUserByName(String name) throws Exception;

    //根据id删除数据
    public void deleteUser(int id) throws Exception;

    //根据id修改用户数据
    public void updateUser(User user) throws Exception;

    //添加用户数据
    public void insertUser(User user) throws Exception;
}
