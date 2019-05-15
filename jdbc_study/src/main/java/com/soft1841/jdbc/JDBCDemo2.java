package com.soft1841.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 向数据库增加信息
 */
public class JDBCDemo2 {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) throws SQLException ,ClassNotFoundException{
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库。。。");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //拼写SQL语句，用？作为参数占位符（姓名和年龄）
        String sql = "INSERT INTO t_student (name,age) VALUES (?,?)";
        System.out.println("实例化PreparedStatement对象。。。");
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //给两个参数设值
        pstmt.setString(1,"测试用户");
        pstmt.setInt(2,20);
        int n = pstmt.executeUpdate();
        System.out.println(n + "行记录受影响");
        pstmt.close();
        conn.close();
    }
}
