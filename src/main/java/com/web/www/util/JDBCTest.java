package com.web.www.util;

import java.sql.*;

public class JDBCTest {

    public static void main(String[] args){

     String user = "root";
     String password = "root";
     String url = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&serverTimezone=UTC";
     String driver = "com.mysql.cj.jdbc.Driver";

     String tableName = "mytable";
     String sqlstr;
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;

     try
     {
         Class.forName(driver);
         con = DriverManager.getConnection(url,user,password);
         stmt = con.createStatement();

         sqlstr = "select * from "+tableName;
         rs = stmt.executeQuery(sqlstr);

         while(rs.next()){
             System.out.println(rs.getInt("id"));
             System.out.println(rs.getString("name"));
         }
     }catch(ClassNotFoundException e){
         System.out.println("Error! 数据库驱动不存在！");
         System.out.println(e.toString());
     }catch(SQLException e){
         System.out.println("Error! 数据库存在异常！");
         System.out.println(e.toString());
     }finally {
         try{
             if(rs!=null)
                 rs.close();
             if(stmt!=null)
                 stmt.close();
             if(con!=null)
                 con.close();
         }catch(SQLException e){
             System.out.println("Error! 通道关闭异常！");
             System.out.println(e.toString());
         }
     }
    }
}
