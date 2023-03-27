<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/16
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户管理</a></li>
        <li><a href="#">修改用户</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="" method="get">
        <input type="hidden" name="userId" value="${user.userId}">
        <input type="hidden" name="flag" value="modifyUser">
        <ul class="forminfo">
            <li><label>用户邮箱</label><input name="email" type="text" class="dfinput" value="${user.email}"/> </li>
            <li><label>用户密码</label><input name="password" type="text" class="dfinput" value="${user.password}"/></li>
            <li><label>用户名称</label><input name="userName" type="text" class="dfinput" value="${user.userName}"/></li>
            <li><label>&nbsp;</label><input name="btn" onclick="update()" type="submit" class="btn" value="确认保存"/></li>
        </ul>

    </form>
</div>

</body>
</html>
