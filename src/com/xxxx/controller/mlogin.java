package com.xxxx.controller;

import com.xxxx.Dao.MerchantDao;
import com.xxxx.entity.supporter;
import com.xxxx.Dao.MemberDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;


@WebServlet("/mlogin")
public class mlogin extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mname = request.getParameter("name");
//        String phone = new String(request.getParameter("phone").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String mpwd = request.getParameter("password");
        MerchantDao merchantDao = new MerchantDao();//控制类、与数据库连接进行增删查改
        String result = merchantDao.permit(mname, mpwd);//查询数据库中是否存在该数据
        System.out.println("登录提交成功！");
        if(result!=null){
//            supporter usernow = new supporter();
//            usernow.setAccount(phone);
            String tx = merchantDao.select(mname);
            HttpSession session = request.getSession();
            session.setAttribute("msee",tx);
            response.setCharacterEncoding("UTF-8");//设置页面编码格式
//            String b = URLEncoder.encode("登录成功！", "UTF-8");
//            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
//            out.print("<script language='javascript'>alert(decodeURIComponent('"+b+"'));window.location.href='login.html';</script>");
            request.getRequestDispatcher("msee.jsp").forward(request, response);//登陆成功之后跳转到主页
        }else{
            response.setCharacterEncoding("UTF-8");//设置页面编码格式
            String a = URLEncoder.encode("登录失败", "UTF-8");
            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
            out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));window.location.href='login.jsp';</script>");
        }
    }

}

