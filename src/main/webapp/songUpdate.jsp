<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/16
  Time: 17:18
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
        <li><a href="#">歌曲管理</a></li>
        <li><a href="#">修改歌曲</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <form action="songManager.do" method="get">
        <input type="hidden" name="flag" value="modifySong">
        <input type="hidden" name="songId" value="${song.songId}">
        <ul class="forminfo">
            <li><label>歌曲名称</label><input name="songName" type="text" class="dfinput" value="${song.songName}"/> </li>
            <li><label>歌曲地址</label><input name="songAddress" type="text" class="dfinput" value="${song.songAddress}"/></li>
            <li><label>&nbsp;</label><input  type="submit" class="btn" value="确认保存"/></li>
        </ul>

    </form>
</div>
</body>
</html>
