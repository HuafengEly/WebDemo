package com.web.www.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class MybatisTools {

    public static String resource = "mybatis-config.xml";
    public static SqlSessionFactory sessionFactory;

    static{
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            System.out.println("[WebDemo]:MybatisTools static exception!");
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }


}
