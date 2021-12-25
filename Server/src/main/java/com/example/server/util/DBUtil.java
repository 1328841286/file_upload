package com.example.server.util;

import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class DBUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        Properties properties = new Properties();
        try {
            //这里暂时写成绝对路径，为了可移植性需改成下方注释掉的代码
            properties.load(new FileReader("C:\\Users\\13288\\Desktop\\file-transfer-master\\Server\\src\\jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ClassLoader classLoader = DBUtil.class.getClassLoader();
//        URL resource = classLoader.getResource("src/jdbc.properties");
//        if (resource==null){
//            System.out.println("resourece 为空");
//        }
//        String path = resource.getPath();
//        try {
//            properties.load(new FileReader(path));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //赋值
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        driver = properties.getProperty("driver");

        //注册驱动
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt,Connection conn){
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){

        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
