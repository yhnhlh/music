<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/10/23
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/jquery-3.3.1.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="css/index.css">
<script src="js/add2list.js"></script>
<body>
<!-- 音乐数据 -->
<div class="music_data w">
    <!-- 音乐图片 -->
    <span class="data_images">
            <img src="images/w.png" alt="" width="300">
        </span>
    <div class="data_content">
        <!-- 歌名 -->
        <div class="data_name">
            <h1 class="data_name_txt" title="${songName}">${songName}</h1>
        </div>

        <!-- 播放器 -->
        <div class="player">

        </div>
        <audio controls="controls">
            <source src="${songAddress}" type="audio/mpeg">
            <embed height="100" width="100" src="${songAddress}">
        </audio>

    </div>

</div>

<div class="comment w" id="comment">
    <div class="comment_title">
        <h2>评论</h2>
    </div>
    <textarea class="comment_box" id="text">说说您的看法吧！</textarea>
    <div class="comment_send">
        <a href="javascript:;" onclick="reviewFunc(${songId})">发表评论</a>
    </div>

    <div class="comment_selected">
        <div class="comment_selected_titile">
            <h2><a href="#" name="content">精选评论</a></h2>
        </div>
    </div>
    <!-- 评论列表 -->
    <ul class="comment_list" id="review_content">
     <c:forEach items="${hotReviews}" var="review1" varStatus="status">
        <li class="comment_list_one">
            <!-- 第一个完整的评论 -->
            <div>
                <div class="comment_list_right">
                    <h4><a href="#">用户ID ${review1.userId}</a></h4>
                    <div>${review1.reviewTime}</div>
                    <p> <span>${review1.review}</span> </p>
                </div>
            </div>
        </li>
     </c:forEach>
    </ul>
</div>

</body>
</html>
