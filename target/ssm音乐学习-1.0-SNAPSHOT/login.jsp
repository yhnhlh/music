<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/13
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>

<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/clear.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="icon" href="images/title-lolg.png">
</head>
<body>
<div id="login_wrap">
    <div class="login ">
        <div id="status">
            <i style="top: 0">登录</i>
        </div>
        <span>
            	<form action="login.do" method="get">
                        <p class="form"><input type="text" name="email" placeholder="用户名"></p>
                        <p class="form"><input type="password" name="password" id="password" placeholder="密码"></p>
                        <input type="submit" value="登录" class="btn"  style="margin-right: 20px;" onclick="login()">
                        <input type="button" value="立即注册" class="btn" name="btn" onclick="tosign()">
                </form>
                    <a href="#">忘记密码?</a>
            <font color="#a52a2a" size="8">${requestScope.msg}</font>
            </span>
    </div>
    <div class="sign disnone">
        <div id="status">
            <i style="top: 0">注册</i>
        </div>
        <span>
            	<form action="register.do" method="get">
                        <p class="form"><input type="text" name="email" id="suser" placeholder="邮箱"></p>
                        <p class="form"><input type="password"  name="password1" id="spasswd" placeholder="密码"></p>
                        <p class="form"><input type="password" name="password2" id="spasswdtwo" placeholder="再次输入密码"></p>
                        <p class="form"><input type="text" name="username" id="" placeholder="用户名"></p>
                        <input type="button" value="立即登录" class="btn"   style="margin-right: 20px;" onclick="tologin()">
                        <input type="submit" value="注册" class="btn" id="btn" onclick="sign()">
                    </form>
            </span>

    </div>
    <!-- <div class="login-img">
        <video src="media/login-video.mp4" autoplay controls></video>
        <div class="img">
        </div>
    </div> -->
</div>
<script src="js/login.js"></script>
</body>
</html>
