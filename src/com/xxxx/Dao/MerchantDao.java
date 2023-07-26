package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MerchantDao {
    public static ResultSet executeQuery;

    public String permit(String maccount, String mpassword) {
        Connection con = Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "select mname from public.merchant where mname='" + maccount + "' and mno='" + mpassword + "';";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet executeQuery0 = pst.executeQuery();
            if (executeQuery0.next()) {
                return executeQuery0.getString("mname");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return null;
    }
    public static String tx="";
    public String select(String maccount) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "select supporter.account,accumulation,city,content from public.supporter,public.footprint,public.message where public.supporter.account=public.footprint.account and public.footprint.account=public.message.account;";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            executeQuery = pst.executeQuery();
            while (executeQuery.next()) {
                for(int i=1;i<=executeQuery.getMetaData().getColumnCount();i++) {
//                    System.out.print(executeQuery.getObject(i) + "\t");
                    tx = tx+executeQuery.getObject(i)+"\t";
                }
                tx = tx+"\n";
            }
            System.out.println(tx);
            return tx;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return null;
    }
}