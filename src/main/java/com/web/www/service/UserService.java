package com.web.www.service;

import com.web.www.dao.UserMapper;
import com.web.www.entity.User;
import com.web.www.util.MybatisTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public static void main(String args[]){
        insertUser();
        updateUser();
        deleteUser();
        selectUserById();
        selectAllUser();
    }

    public static void insertUser(){
        SqlSession session = MybatisTools.getSession();
        UserMapper dao = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("insertuser");
        user.setPassword("123456");
        try{
            dao.insertUser(user);
            System.out.println("[WebDemo]:UserService insert succeed!");
            System.out.println(user.toString());
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void updateUser(){
        SqlSession session = MybatisTools.getSession();
        UserMapper dao = session.getMapper(UserMapper.class);
        User user = new User();
        user.setId(2);
        user.setUsername("insertuser");
        user.setPassword("123456");
        try{
            dao.updateUser(user);
            System.out.println("[WebDemo]:UserService update succeed!");
            System.out.println(user.toString());
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void deleteUser(){
        SqlSession session = MybatisTools.getSession();
        UserMapper dao = session.getMapper(UserMapper.class);
        try{
            dao.deleteUser(3);
            System.out.println("[WebDemo]:UserService delect succeed!");
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void selectUserById(){
        SqlSession session = MybatisTools.getSession();
        UserMapper dao = session.getMapper(UserMapper.class);
        try{
            User user = dao.selectUserById(1);
            System.out.println("[WebDemo]:UserService selectUserById succeed!");
            System.out.println(user.toString());
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void selectAllUser(){
        SqlSession session = MybatisTools.getSession();
        UserMapper dao = session.getMapper(UserMapper.class);
        try{
            List<User> user = dao.selectAllUser();
            System.out.println("[WebDemo]:UserService selectAllUser succeed!");
            System.out.println(user.toString());
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
            session.rollback();
        }
    }

}
