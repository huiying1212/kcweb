package com.xxxx.controller;

import com.xxxx.Dao.CityDao;
import com.xxxx.entity.footprint;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/city")
public class city extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取index.jsp中城市输入的相关数据
        String account = request.getParameter("field_name");
        String city = new String(request.getParameter("cityname").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        CityDao cityDao = new CityDao();//控制类、与数据库连接进行增删查改
        System.out.println(city);
        String result = cityDao.addcity(city, account);//在数据库中添加数据
        if(result!=null){
            footprint userfoot = new footprint();
            userfoot.setCity(result);
//            response.setCharacterEncoding("UTF-8");//设置页面编码格式
//            String b = URLEncoder.encode("城市填写成功！", "UTF-8");
//            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
//            out.print("<script language='javascript'>alert(decodeURIComponent('"+b+"'));window.location.href='login.jsp';</script>");
//            request.getRequestDispatcher("index.html").forward(request, response);//登陆成功之后跳转到主页
        }else{
//            response.setCharacterEncoding("UTF-8");//设置页面编码格式
//            String a = URLEncoder.encode("城市填写失败", "UTF-8");
//            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
//            out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));window.location.href='login.jsp';</script>");
        }
    }

}