package com.bdqn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * MyBatis工具类
 */
public class MyBatisUtil {
    private static final String CONFIG_FILE_NAME = "MyBatis-Config.xml";
    private static final ThreadLocal<SqlSession> sessionThreadLocal = new ThreadLocal<>();
    private static SqlSessionFactory factory = null;

    /**
     * 静态代码块，创建Sql会话工厂
     */
    static {
        try {
            InputStream in = Resources.getResourceAsStream(CONFIG_FILE_NAME);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    //获取会话工厂对象引用
    public static SqlSessionFactory getSqlSessionFactory(){
        return factory;
    }

    /**
     * 获得数据库会话对象
     *
     * @return
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = sessionThreadLocal.get();
        if (sqlSession == null) {
            //openSession(true) 表示自动提交数据库事务,但是最好是手动提交数据库事务，以便于出错异常，可以回滚数据库事务
            sqlSession = factory.openSession(false);
            sessionThreadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭数据库会话
     */
    public static void closeSqlSession() {
        SqlSession sqlSession = sessionThreadLocal.get();
        if (sqlSession != null) {
            sqlSession.close();
            sessionThreadLocal.remove();
        }
    }
}
