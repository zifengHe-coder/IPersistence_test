package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class IPersistenceTest {
    private static Logger logger = LoggerFactory.getLogger(IPersistenceTest.class);



    @Test
    public void test() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User result = userDao.findByCondition(user);
        System.out.println(result);
    }

    @Test
    public void insertTest() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(3);
        user.setUsername("tom1");
        user.setAge(21);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int flag = userDao.insertUser(user);
        System.out.println(flag == 1 ? "新增成功" : "新增失败");
    }

    @Test
    public void updateTest() throws Exception {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(1);
        user.setUsername("tom2");
        user.setAge(21);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int flag = userDao.updateUser(user);
        System.out.println(flag == 1 ? "更新成功" : "更新失败");
    }

    @Test
    public void deleteTest() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setId(3);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        int flag = userDao.deleteUser(user);
        System.out.println(flag == 1 ? "删除成功" : "删除失败");
    }
}
