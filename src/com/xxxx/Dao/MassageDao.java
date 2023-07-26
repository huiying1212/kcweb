package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MassageDao {
    public static String addmassage(String account,String comment1,String comment2) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "INSERT INTO public.message(account, content)VALUES('"+account+"', '"+comment1+"："+comment2+"');";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet executeQuery = pst.executeQuery();
            if (executeQuery.next()) {
//                return executeQuery.getString("city");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return account;
    }
}