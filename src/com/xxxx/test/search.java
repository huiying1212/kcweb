package com.xxxx.test;

import com.xxxx.util.Conhgdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class search {
    public static ResultSet sel(Connection con, String fld, String tbl) {
        String s="select "+fld+" from "+tbl+" where saccount='account01' and spassword='123456'";
        System.out.println(s);
        return excusql(con,s);
    }
    private static ResultSet excusql(Connection con, String s) {
        ResultSet rs=null;
        try {
            PreparedStatement ps=con.prepareStatement(s);
            rs=ps.executeQuery();
            while(rs.next()) {
                for(int i=1;i<=rs.getMetaData().getColumnCount();i++)//
                    System.out.print(rs.getObject(i)+"\t");
                System.out.println();
            }
        }catch(SQLException ex) {
            System.out.print("Error:"+ex.getMessage());
            ex.printStackTrace(System.out);
        }finally {
            if(con!=null) {
                try{
                    con.close();
                    System.out.println("connection closed!");
                }catch(SQLException e) {e.printStackTrace();}
            }
        }
        return rs;
    }
    public static void main(String[] args) {
        Connection con= Conhgdb.getConnections("highgo","5866","hg2web");
        sel(con,"*","public.supporter");
    }

}