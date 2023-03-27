<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/16
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".click").click(function(){
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function(){
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function(){
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function(){
                $(".tip").fadeOut(100);
            });

        });
    </script>

</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户管理</a></li>
        <li><a href="#">查询用户</a></li>
        <li><a href="#">查询结果</a></li>
    </ul>
</div>

<div class="rightinfo">


    <div class="formtitle1"><span>用户列表</span></div>

    <table class="tablelist" >
        <thead>
        <tr>
            <th>用户ID</th>
            <th>用户邮箱</th>
            <th>用户密码</th>
            <th>用户名称</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.userId}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.userName}</td>
            <td><a href="userManager.do?flag=preUpdate&email=${user.email}" class="tablelink">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;  <a href="userManager.do?userId=${user.userId}" class="tablelink click"> 删除</a></td>
        </tr>
        </c:forEach>

        </tbody>
    </table>



    <div class="tip">
        <div class="tiptop"><span>提示信息</span><a></a></div>

        <div class="tipinfo">
            <span><img src="images/ticon.png" /></span>
            <div class="tipright">
                <p>是否确认对信息的修改 ？</p>
                <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
            </div>
        </div>

        <div class="tipbtn">
            <input name="" type="button"  class="sure" value="确定" />&nbsp;
            <input name="" type="button"  class="cancel" value="取消" />
        </div>

    </div>




</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>
</html>
