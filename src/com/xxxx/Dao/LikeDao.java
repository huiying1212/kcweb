package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDao {

    public static String addlike1(String account) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "update public.footprint set likecon1=1 where account='"+account+"'";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
//            if (executeQuery.next()) {
//                return executeQuery.getString("likecon1");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return "点赞成功！您的环保积分将＋1";
    }
    public static String addlike2(String account) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "update public.footprint set likecon2=1 where account='"+account+"'";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return "点赞成功！您的环保积分将＋1";
    }
    public static String addlike3(String account) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "update public.footprint set likecon3=1 where account='"+account+"'";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Conhgdb.close(con);
        }
        return "点赞成功！您的环保积分将＋1";
    }
}