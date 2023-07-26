<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@page import="java.sql.*"%>
<%@ page import="com.xxxx.util.Conhgdb" %>
<%--导入java.sql包--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>信息</title>
    <style type="text/css">
        .header {
            background-color: #f1f1f1;
            padding: 10px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="header">
    <h3>查询结果</h3>
    <p>以下内容均来自用户的使用记录, 您可以据此获取相关市场信息</p>
</div>
<center>
    <%
        try {
            Connection con= Conhgdb.getConnections("highgo", "5866", "hg2web"); //连接状态
//            out.println("数据库连接成功！");
    %>
    <table border="2">
        <tr>
            <th>账号</th>
            <th>环保积分</th>
            <th>城市需求</th>
            <th>留言内容</th>
        </tr>
            <%
				Statement stmt = null;
					ResultSet rs = null;
					String sql = "select supporter.account,accumulation,city,content from public.supporter,public.footprint,public.message where public.supporter.account=public.footprint.account and public.footprint.account=public.message.account;"; //查询语句
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					out.print("<br/>");
					while (rs.next()) {
			%>
        <tr>
            <td><%=rs.getString("account")%></td>
            <td><%=rs.getString("accumulation")%></td>
            <td><%=rs.getString("city")%></td>
            <td><%=rs.getString("content")%></td>
        </tr>
            <%
				}
				} catch (Exception e) {
					e.printStackTrace();
//					out.println("数据库连接失败");
				}
			%>
</center>
</body>
</html>

