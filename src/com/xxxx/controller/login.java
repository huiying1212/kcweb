package com.xxxx.controller;

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


@WebServlet("/login")
public class login extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String account = request.getParameter("name");
//        String phone = new String(request.getParameter("phone").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String pwd = request.getParameter("password");
        MemberDao memberDao = new MemberDao();//控制类、与数据库连接进行增删查改
        String result = memberDao.login(account, pwd);//查询数据库中是否存在该数据
        memberDao.addfootprint(account);
//        System.out.println("新增到footprint中的账号："+result2);
        System.out.println("登录提交成功！");
//        response.setCharacterEncoding("UTF-8");//设置页面编码格式
//        request.getRequestDispatcher("index.html").forward(request, response);//登陆成功之后跳转到主页
        if(result!=null){
            supporter usernow = new supporter();
            usernow.setAccount(account);
            usernow.setPassword(pwd);
            usernow.setPpath(result);
            java.awt.Image pic = new java.awt.Image() {
                @Override
                public int getWidth(ImageObserver observer) {
                    return 0;
                }

                @Override
                public int getHeight(ImageObserver observer) {
                    return 0;
                }

                @Override
                public ImageProducer getSource() {
                    return null;
                }

                @Override
                public Graphics getGraphics() {
                    return null;
                }

                @Override
                public Object getProperty(String name, ImageObserver observer) {
                    return null;
                }
            };
            usernow.setPortrait(pic);
            HttpSession session = request.getSession();
            session.setAttribute("user",usernow);

            response.setCharacterEncoding("UTF-8");//设置页面编码格式
            String b = URLEncoder.encode("登录成功！", "UTF-8");
            PrintWriter out2 = response.getWriter();//打开流之后设置编码会无效
            out2.print("<script language='javascript'>alert(decodeURIComponent('"+b+"'));window.location.href='index.html';</script>");
//            request.getRequestDispatcher("index.html").forward(request, response);//登陆成功之后跳转到主页
        }else{
            response.setCharacterEncoding("UTF-8");//设置页面编码格式
            String a = URLEncoder.encode("登录失败", "UTF-8");
            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
            out.print("<script language='javascript'>alert(decodeURIComponent('"+a+"'));window.location.href='login.jsp';</script>");
        }
    }

}

