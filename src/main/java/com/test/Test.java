package com.test;

import com.test.entity.User;
import com.test.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        //加载MyBatis配置文件
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取实现接口的代理对象
        UserRepository repository = sqlSession.getMapper(UserRepository.class);
        User user = new User();
        user.setId(1);
        //user.setUsername("张三");
        //user.setPassword("123");
        user.setAge(22);
        User user1  =repository.get(user);
        System.out.println(user1);
    }
}