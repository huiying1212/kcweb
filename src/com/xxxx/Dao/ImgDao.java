package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImgDao {
    public String addimg(String path, String account, String ppath) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "update public.supporter set portrait=(select public.fun_imagetobytea ('C:/headimg/"+path+"')),ppath='"+ppath+"' where account='"+account+"';";
        System.out.println(sql);
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conhgdb.close(con);
        }
        return account;//强制返回
    }
}
