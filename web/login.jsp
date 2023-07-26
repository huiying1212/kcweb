<%--
  Created by IntelliJ IDEA.
  User: Kate
  Date: 2022/12/29
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>登录</title>
  <style type="text/css">
    .header {
      background-color: #f1f1f1;
      padding: 10px;
      text-align: center;
    }
    .wrap{
      /*margin表示外边距*/
      margin-top: 50px;
      width: 500px;
      height: 500px;
      /*background-color: #ccc; */
      margin-left: 455px;
    }
    .input{
      width: 250px;
      height: 40px;
      margin-top: 40px;
      margin-left: 30px;
    }
    .logC{
      margin-left: 18px;
      width: 60%;
      height: 45px;
      background-color: dimgray;
      color: white;
      font-size: 18px;
      margin-top: 70px;
    }
    .regist{
      margin-top: 20px;
      float: right;
      margin-right: 100px;
    }
  </style>

</head>
<body>
<!-- class用于style中控制div样式，也可以直接改为style="",将属性写在style中 -->
<div class="header">
  <h1>欢迎登录</h1>
  <p>填写您的账号及密码, 即可进入From Pollution To Solution页面!</p>
</div>
<div class="wrap">
  <!-- from是一个表单，点击提交按钮时可以将输入框内容提交到action后的页面，method表示servelet请求方式 -->
  <form  name="form" action="#" method="post">
    <div>
      <!-- b标签表示加粗字体 -->
      <b>账 号:</b>
      <!-- placeholder表示输入框预设文字 -->
      <input class="input"  type="text" name="name" placeholder="请输入您的账号" />
    </div>
    <br>
    <div>
      <b>密 码:</b>
      <input class="input" type="password" name="password" placeholder="请输入您的密码" />
    </div >
    <br>
    <!-- submit表示提交按钮 -->
    <input class="logC" onClick="log()" type="button" name="login" value="登录">

  </form>
  <div class="regist">
    <!-- a标签表示链接 ，用于页面跳转-->
    还没有账号?&nbsp&nbsp<a href="regist.html">立即注册</a>
  </div>
  <script type="text/javascript">
    //定义log函数
    function log() {
      var name = document.form.name.value;
      var password = document.form.password.value;
      if (name==null||""==name) {
        alert("账号为空，请重新输入");
      } else if(password==null||""==password){
        alert("密码为空，请重新输入");
      }else{
        //#表示servlet
        document.form.action = "/login";
        document.form.submit();
      }
    }
  </script>

</div>

</body>

</html>




</body>
</html>
