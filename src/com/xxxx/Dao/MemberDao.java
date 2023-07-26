package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
    public static InputStream ips;

    public String login(String account, String password) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "select portrait,ppath from public.supporter where account='" + account + "' and password='" + password + "';";
        System.out.println(sql);
        ips=null;
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet executeQuery = pst.executeQuery();
            if (executeQuery.next()) {
//                Image pic = (Image) executeQuery.getObject("portrait");
                ips=executeQuery.getBinaryStream(1);//bytea——>InputStream
//                return ips.toString();
                return executeQuery.getString("ppath");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return null;
    }

    public static void addfootprint(String account) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "INSERT INTO public.footprint(account)VALUES('"+account+"')";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
//        return account;
    }
}
