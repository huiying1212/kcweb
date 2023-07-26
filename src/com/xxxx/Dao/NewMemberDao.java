package com.xxxx.Dao;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class NewMemberDao {
    public String regist(String account, String password, String name2, String email) {
        Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web");
        String sql = "INSERT INTO public.supporter(account, password, name2, email)VALUES('"+account+"', '"+password+"','"+name2+"','"+email+"');";
        System.out.println(sql);
        String sql2 = "select account from public.supporter where account='" + account + "';";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.executeQuery();
//            PreparedStatement pst2 = con.prepareStatement(sql2);
//            ResultSet executeQuery2 = pst2.executeQuery();
//            if (executeQuery2.next()) {
//                return executeQuery2.getString("account");
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            Conhgdb.close(con);
        }
        return account;//强制传值
    }
}
