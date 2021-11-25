package Mapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import pojo.User;
import utils.mybatiutils;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test(){
        //第一步：获取SqlSession对象
        SqlSession sqlSession = mybatiutils.getSqlSession();
        logger.info("s********************************************");

        //执行SQL
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void  addUser(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int dsadsa = mapper.addUser(new User(4, "dsadsa", "12344"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int xixi = mapper.updateUser(new User(4, "xixi", "66666"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = mybatiutils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserByLimit(){

        SqlSession sqlSession = mybatiutils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list = mapper.getUserByLimit(map);
        for (User user : list) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
