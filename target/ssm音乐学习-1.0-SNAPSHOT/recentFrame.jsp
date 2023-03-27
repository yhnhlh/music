<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/15
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="col-12 <c:if test="${ (not empty myRecentPlayList) }">border</c:if>">

    <ul class="list-group list-group-flush">
        <c:forEach items="${myRecentPlayList}" var="song" varStatus="status">
            <li class="list-group-item list-group-item-light "
                idd="${song.songId}" title="${song.songName}">
                <!-- 歌曲信息区 -->
                <div class="clear text-ellipsis">
                    <span><a href="#" class="ahover" onclick="reviewLoad(${song.songId})">${status.index+1}.${song.songName}</a></span>
                    <span class="text-muted"> -- _ _ -- </span>
                    <span class="text-danger icon-fire"></span>
                </div> <!-- 播放控制区 downloadFun(${song.songAddress})-->
                <div class="pull-right m-l fr">
                    <a href="play.do?songAddress=${song.songAddress}&songId=${song.songId}&songName=${song.songName}" class="play m-r-sm" title="播放" onclick="playFunc(${song.songId})" id="play${song.songId}" name="${song.songName}" address="${song.songAddress}"> <i
                            class="icon-control-play text  "></i> <!-- <i class="icon-control-pause text-active"></i> -->
                    </a> <a
                        href="${pageContext.request.contextPath}/download.do?songAddress=${song.songAddress}&songId=${song.songId}&songName=${song.songName}"
                        class="m-r-sm" title="下载"><i class="icon-cloud-download"></i></a>
                    <a href="javascript:;"
                            <c:choose>
                                <c:when test="${song.whetherCollected}">class="collect m-r-sm text-danger"</c:when>
                                <c:otherwise>class="collect m-r-sm"</c:otherwise>
                            </c:choose>
                       onclick="collectFunc(${song.songId})" id="${song.songId}"
                       title="喜欢"><i class="icon-heart"></i> </a>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
