package com.xxxx.util;

import java.sql.*;

public class Conhgdb {
    public static Connection con;
    public static Connection getConnections(String db,String duankou, String datname) {
        String driver = "com."+db+".jdbc.Driver";
        String url = "jdbc:"+db+"://localhost:"+duankou+"/" + datname;
        String username = "highgo";
        String password = "Highgo@5866";
        try {//加载驱动
            Class.forName (driver);//获得数据库连接
            con=DriverManager.getConnection(url, username, password);
            System.out.println(datname+" to be connection succeed!");
        }catch (ClassNotFoundException e) {
            System.out.println("DriverNotFound");   e.printStackTrace();
        }catch (SQLException e) {
            System.out.println("Failed to connect!");   e.printStackTrace();
        }
        return con;
    }
    public static void close(Connection con) {
        // 关闭资源，避免出现异常
//        if(rs != null){
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        if(ps != null){
//            try {
//                ps.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        if (con != null)
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
//    public static void main(String[] args) {
//        getConnections("highgo", "5866", "hg2web");
//    }
}