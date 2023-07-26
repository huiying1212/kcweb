package com.xxxx.controller;

import com.xxxx.Dao.NewMemberDao;
import com.xxxx.Dao.ImgDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/regist")
public class regist extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } // 解析request请求
        Iterator iter = items.iterator();// 遍历表单中提交过来的内容
        String account = null;
        String pwd = null;
        String name2 = null;
        String email = null;
        String context;
        String filename = null;
        String contextnew = null;
        while (iter.hasNext()) {
            FileItem item = (FileItem) iter.next();
            if (item.isFormField()) { // 如果是表单域 ，就是非文件上传元素
                String value = item.getString("UTF-8"); // 获取value属性的值，这里需要指明UTF-8格式，否则出现中文乱码问题
                if (item.getFieldName().equals("name")) {// 对应form中属性的名字
                    account = value;
                } else if (item.getFieldName().equals("password")) {
                    pwd = value;
                } else if (item.getFieldName().equals("name2")) {
                    name2 = value;
                } else if (item.getFieldName().equals("email")) {
                    email = value;
                }
            } else {
                request.setCharacterEncoding("utf-8");
                filename = item.getName();
                contextnew = "headimg/" + filename;//新增路径栏的内容
                // 5. 调用FileItem的write()方法，写入文件
                context = "C:/IJ/SDGsWEB/web/headimg/" + filename;
                System.out.println("图片的另存路径为" + context);
                File file1 = new File(context);
                System.out.println(file1.getAbsolutePath());
                try {
                    item.write(file1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        NewMemberDao newmemberDao = new NewMemberDao();//控制类、与数据库连接进行增删查改
        System.out.println(account);
        System.out.println(pwd);
        String result = newmemberDao.regist(account, pwd, name2, email);//查询数据库中是否存在该数据
        System.out.println("注册信息提交成功！");
        if (result != null) {
            response.setCharacterEncoding("UTF-8");//设置页面编码格式
            String b = URLEncoder.encode("注册成功！", "UTF-8");
            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
            out.print("<script language='javascript'>alert(decodeURIComponent('"+b+"'));window.location.href='login.jsp';</script>");
//            request.getRequestDispatcher("login.jsp").forward(request, response);//注册成功之后跳转
        } else {
            response.setCharacterEncoding("UTF-8");//设置页面编码格式
            String a = URLEncoder.encode("注册失败", "UTF-8");
            PrintWriter out = response.getWriter();//打开流之后设置编码会无效
            out.print("<script language='javascript'>alert(decodeURIComponent('" + a + "'));window.location.href='regist.html';</script>");
        }
        ImgDao imgDao = new ImgDao();
        imgDao.addimg(filename, account, contextnew);//contextnew是新增路径栏的内容，对应ppath
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

