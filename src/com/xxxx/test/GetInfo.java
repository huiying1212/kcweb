package com.xxxx.test;

import com.xxxx.util.Conhgdb;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class GetInfo {/**存储要查询表的字段信息集rs*/
    public static ResultSet getRs(String datn, String tbln) {
        Connection con= Conhgdb.getConnections("highgo","5866",datn);
        ResultSet rs=null;
        try{
            DatabaseMetaData metaData = con.getMetaData();
            rs=metaData.getColumns(null,null,tbln,"%");
//int i = 1;
//while (rs.next())
//System.out.printf("%d:%s(%d)\n",i++,rs.getString("COLUMN_NAME"),
//			rs.getInt("ORDINAL_POSITION"));
			}catch(SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }finally {
            try{if(con!=null)	con.close();}
            catch(SQLException e) {
                System.err.println(e.getClass().getName()+": "+e.getMessage());
            }
        }
        return rs;
    }/**获取要查询表的字段名称数组buf*/
    public static List<String> getColnames(String datn, String tbln) {
        ResultSet rs=getRs(datn,tbln);
        List<String> buf=new ArrayList<>();
        try {
            while(rs.next()) {//不允许为空的字段
//				if(rs.getInt("NULLABLE")<1){
				buf.add(rs.getString("Column_Name"));
//					System.out.println(rs.getString("Column_Name"));
//				}
				}
        }catch(Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return buf;
    }/**获取要查询表的字段数据类型数组buf*/
    public static List<String> getTypes(String datn, String tbln){
        List<String> buf=new ArrayList<>();
        ResultSet rs=getRs(datn,tbln);
        try {
            while(rs.next()) {
                buf.add(rs.getString("Type_Name"));
            }
        }catch(Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
        return buf;
    }/**打印数据库datn下数据表tbl的字段名称*/
    public static void dispflds(String datn, String tbl){
        List<String> buf=getColnames(datn,tbl);
        for(int i=0;i<buf.size();i++)
            System.out.printf("%-13s\t",buf.get(i));
        System.out.println();
    }
    public static void main(String[] args) throws Exception{
        String datn="st",tbl="student";
        dispflds(datn,tbl);
//		ResultSet rs=getRs(datn,tbl);
//		System.out.println(rs.next());
//		System.out.println(rs.getString("TABLE_NAME"));//TABLE_NAME
//		System.out.println(rs.getString("column_name"));//COLUMN_SIZE
//		System.out.println(rs.getString("column_size"));
    }
}