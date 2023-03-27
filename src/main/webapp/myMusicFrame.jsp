<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/14
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- simple-line-icons CSS http://www.bootcdn.cn/simple-line-icons/-->
    <link rel="stylesheet" href="css/simple-line-icons.css" >
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/add2list.js"></script>
    <script>
        function toPlayShow()
        {
            document.getElementById("list-profile-list").classList.remove('active');
            document.getElementById("list-home-list").classList.add('active');
            document.getElementById("list-home").classList.add("active");
            document.getElementById("list-profile").classList.remove("active");
        }
        function toColletShow()
        {

            document.getElementById("list-home-list").classList.remove('active');
            document.getElementById("list-profile-list").classList.add('active');
            document.getElementById("list-home").classList.remove("active");
            document.getElementById("list-profile").classList.add("active");
        }
    </script>
</head>
<body>
<h3 align="left"><a href="index.jsp">返回</a></h3>
<div class="container">

    <h3>我的音乐 </h3>
    <div class="row content hot-content">

        <!--DIV 歌曲部分-->
        <div class="col-sm-10 h-item" id="mytest"><!-- 中DIV -->
            <!-- One of three columns -->


            <div class="row">
                <div class="col-4">
                    <div class="list-group" id="list-tab" role="tablist">
                        <a class="list-group-item list-group-item-action active" id="list-home-list" data-toggle="list" href="#list-home" role="tab" aria-controls="home" onclick="toPlayShow()">我的收藏</a>
                        <a class="list-group-item list-group-item-action " id="list-profile-list" data-toggle="list" href="#list-profile" role="tab" aria-controls="profile" onclick="toColletShow()">最近播放</a>
                    </div>
                </div>
                <div class="col-8">
                    <div class="tab-content" id="nav-tabContent">
                        <!-- 我的收藏 -->
                        <div class="tab-pane fade show active " id="list-home" role="tabpanel" aria-labelledby="list-home-list">
                            <ul class="list-group list-group-flush" >
                                <li class="list-group-item list-group-item-light " idd="" title="">
                                    <!-- 歌曲信息区 -->
                                    <div class="clear text-ellipsis">
                                        <span>1.songname</span>
                                        <span class="text-muted"> -- _ _ -- </span>
                                        <span class="text-danger icon-fire"></span>
                                    </div>
                                    <!-- 播放控制区 downloadFun(${song.songAddress})-->
                                    <div class="pull-right m-l fr">
                                        <a href="javascript:;" class="play m-r-sm" title="播放" onclick="" id="yhn" name="" address="">
                                            <i class="icon-control-play text  "></i>
                                            <!-- <i class="icon-control-pause text-active"></i> -->
                                        </a>
                                        <a href="" class="m-r-sm" title="下载"><i class="icon-cloud-download"></i></a>
                                        <a href="javascript:;" title="喜欢">
                                            <i class="icon-heart"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </div><!-- 我的收藏 End-->
                        <!-- 最近播放 -->
                        <div class="tab-pane fade show" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">
                            <ul class="list-group list-group-flush" >
                                <li class="list-group-item list-group-item-light " idd="" title=""  data-duration="" data-name="">
                                    <!-- 歌曲信息区 -->
                                    <div class="clear text-ellipsis">
                                        <span>11.song.songName</span>
                                        <span class="text-muted"> -- _ _ -- </span>
                                        <span class="text-danger icon-fire"></span>
                                    </div>
                                    <!-- 播放控制区 downloadFun(${song.songAddress})-->
                                    <div class="pull-right m-l option fr">
                                        <a href="javascript:;" class="play m-r-sm" title="播放">
                                            <i class="icon-control-play text  "></i>
                                            <!-- <i class="icon-control-pause text-active"></i> -->
                                        </a>
                                        <a href="" class="m-r-sm" title="下载"><i class="icon-cloud-download"></i></a>
                                        <a href="javascript:;" class="collect m-r-sm text-danger"
                                           onclick="" id="" title="喜欢"><i class="icon-heart"></i>
                                        </a>
                                    </div>
                                </li>

                            </ul>
                        </div><!-- 最近播放 End-->
                    </div>
                </div>
            </div>
        </div>



    </div><!--中DIV 歌曲部分 End-->
    <!-- 后DIV -->
    <div class="col-sm-1"></div><!-- 该后DIV为了中DIV居中 -->

</div>

<script>
    $(function(){
        $('#list-home').load("myMusicPage.do?flag=collectedFrameLoad");
        //处理我的收藏tab切换
        $('#list-tab a[href="#list-home"]').on('click', function (e) {
            $('#list-home').load("myMusicPage.do?flag=collectedFrameLoad");
        });
        //处理最近播放tab切换
        $('#list-tab a[href="#list-profile"]').on('click', function (e) {
            $('#list-profile').load("myMusicPage.do?flag=recentFrameLoad");
        });
    });
</script>
</body>
</html>
