package com.lagou.dao;

import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Before;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;


public class UserDaoImpl implements IUserDao{
    private SqlSession sqlSession;

    @Before
    public void initSqlSession() throws PropertyVetoException, DocumentException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        this.sqlSession = sqlSession;
    }


    @Override
    public List<User> findAll() throws Exception {
        //调用
        List<User> list = sqlSession.selectList("com.lagou.mapper.UserMapper.selectList");
        for (User user : list) {
            System.out.println(user);
        }
        return list;
    }

    @Override
    public User findByCondition(User user) throws Exception {
        //调用
        User result = (User)sqlSession.selectOne("com.lagou.mapper.UserMapper.selectOne", user);
        System.out.println(result);
        return result;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }
}
