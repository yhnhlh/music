<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/13
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="fileUpload.do" method="post" enctype="multipart/form-data">
    文件描述：<input type="text" name="desc"/><br/>
    上传文件：<input type="file" name="file"/><br/>
    <input type="submit" value="OK"/>
</form>
</body>
</html>
