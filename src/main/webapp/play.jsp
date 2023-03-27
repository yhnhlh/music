<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/15
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/play.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="main">
    <p id="logo"><i class="fa fa-music"></i>Music</p>

    <!--- left part --->
    <div class="left">

        <!--- song img --->
        <img src="images/5.jpg">
        <div class="volume">
            <p id="volume_show">90</p>
            <i class="fa fa-volume-up" aria-hidden="true" onclick="mute_sound()" id="volume_icon"></i>
            <input type="range" min="0" max="100" value="90" onchange="volume_change()" id="volume">
        </div>

    </div>


    <!--- right part --->
    <div class="right">


        <p id="artist">${songName}</p>

        <!--- middle part --->
        <div class="middle">
            <audio controls="controls">
                <source src="${songAddress}" type="audio/mpeg">
                <embed height="100" width="100" src="${songAddress}">
            </audio>
        </div>

        <!--- song duration part --->
        <div class="duration">
            <input type="range" min="0" max="100" value="0" id="duration_slider" onchange="change_duration()">
        </div>
        <button id="auto" onclick="autoplay_switch()">Auto play <i class="fa fa-circle-o-notch" aria-hidden="true"></i></button>
    </div>


</div>


</body>
</html>
