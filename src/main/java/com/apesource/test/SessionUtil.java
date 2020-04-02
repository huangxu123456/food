package com.apesource.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionUtil {
    static SqlSessionFactory build=null;
    static {
        String path="mybatis-config.xml";
        try {
            InputStream  paths = Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
              build = builder.build(paths);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSession() throws IOException {

        return build.openSession();
    }
    public static void close() throws IOException {
        SqlSession session = SessionUtil.getSession();
        session.close();
    }
}
