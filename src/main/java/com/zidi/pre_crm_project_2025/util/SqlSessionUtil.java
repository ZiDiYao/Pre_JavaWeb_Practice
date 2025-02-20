package com.zidi.pre_crm_project_2025.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
    private static final SqlSessionFactory sqlSessionFactory; // ✅ Make it final for immutability

    // 使用 ThreadLocal 让每个线程都有独立的 SqlSession
    private static final ThreadLocal<SqlSession> threadLocalSession = new ThreadLocal<>();

    // 私有构造方法，防止实例化
    private SqlSessionUtil() {}

    static {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load MyBatis configuration file!", e);
        }
    }

    // 获取当前线程的 SqlSession
    public static SqlSession getSession() {
        SqlSession session = threadLocalSession.get();
        if (session == null) {
            session = sqlSessionFactory.openSession(); // 默认不自动提交事务
            threadLocalSession.set(session);
        }
        return session;
    }

    // 关闭 SqlSession 并清除 ThreadLocal
    public static void closeSession() {
        SqlSession session = threadLocalSession.get();
        if (session != null) {
            try {
                session.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                threadLocalSession.remove(); // 确保删除，防止内存泄漏
            }
        }
    }
}
