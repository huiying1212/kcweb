package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CityDao {

    public static String addcity(String city,String account) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "update public.footprint set city='"+city+"' where account='"+account+"'";
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
        return city;
    }
}