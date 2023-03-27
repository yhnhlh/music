<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/13
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.utils.Constants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script>
        if(window.parent.length > 0){
            window.parent.location="index.jsp";
        }
    </script>
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/clears.css">
    <title>首页</title>
    <link rel="icon" href="images/title-lolg.png">
    <!-- 第一张css -->
    <link rel="stylesheet" type="text/css" href="css/one.css" />
    <!-- 第四张css -->
    <link rel="stylesheet" type="text/css" href="css/four.css" />


</head>
<body>
<header>

    <div class="header-body">
        <a href="index.jsp" class="logo">猫眼音乐</a>
        <div class="city">洛阳
            <span class="caret"></span>
        </div>
        <div class="city-list">
            <div class="now-city">
                定位城市: 定位失败
            </div>
            <div class="citys">
                <span class="icon"></span> 定位失败
            </div>
        </div>
        <div class="nav">
            <ul class="nav-list">
                <li><a href="index.jsp" class="nav-model active">首页</a></li>
                <li><a href="personalizedRecFrameLoad.do" class="nav-model">个性化推荐</a></li>
                <li><a href="rankingFrameLoad.do" class="nav-model">排行榜</a></li>
                <li><a href="trendingRecFrame.do" class="nav-model">热门音乐</a></li>
                <li><a href="myMusicFrame.jsp" class="nav-model">我的音乐</a></li>
            </ul>
        </div>
        <div class="app-download">
            <a href="#">
                <span class="phone"></span> APP下载
                <span class="caret"></span>

                <div class="appcode">
                    <img src="images/phonecode.png" class="app-code"></img>
                    <p class="down-tip">扫码下载APP</p>
                    <p class="down-text">听音乐更方便</p>
                </div>
            </a>
        </div>
        <div class="search">
            <form action="searchFrameLoad.do" method="get">
            <div type="text" class="searchinput">
                <input type="text" name="keyWord" class="input" placeholder="音乐">
                <input class="submit" type="submit" value="">
            </div>
            </form>
        </div>
        <div class="userimg">
            <img  src="images/user.png" alt="">
            <span class="caret"></span>
        </div>
        <div class="userlogin">
            <c:if test="${Constants.isLogin==0}">
                <li style="display: block;"><a href="login.jsp" class=" notlogin">登录</a> </li>
            </c:if>
            <c:if test="${Constants.isLogin==1}">
                <li style="display: block;"><a href="logout.do" class=" notlogin">退出</a></li>
                <li style="display: block;"><a href="fileUpload.jsp" class="notlogin">更换头像</a></li>
            </c:if>

        </div>


    </div>
</header>
<!-- 轮播图 -->
<div class="wrap" id="wrap">
    <ul class="content"></ul>
    <a href="javascript:;" class="prev">&#60;</a>
    <a href="javascript:;" class="next">&#62;</a>
</div>

<!-- 第一张 -->
<div id="main">
    <input id="left" type="image" src="images/left.png" name="mainboth" />
    <input id="right" type="image" src="images/right.png" name="mainboth" />
    <div id="title">

        <span>歌</span><span>单</span><span>推</span><span>荐</span>
    </div>
    <div id="nav">
        <ul>
            <li><a style="color:#7dd1a9;" href="">为你推荐</a></li>
            <li><a href="">网络歌曲</a></li>
            <li><a href="">经典</a></li>
            <li><a href="">佛教音乐</a></li>
            <li><a href="">官方歌曲</a></li>
            <li><a href="">情歌</a></li>
        </ul>
    </div>
    <div id="lunbo">
        <ul id="lunbomain">
            <li><a href="trendingRecFrame.do"> <span><img id='pic' src="images/h.png"><img src="images/hp1.png"></span></a><span></span>
                <p><a href="">温柔嗓音：人间星光，星河灿烂</a></p>
                <p id="qwe">播放量: 770.5万</p>
            </li>
            <li><a href="trendingRecFrame.do"><span><img id='pic' src="images/h.png"><img src="images/hp2.jfif"></span></a><span></span>
                <p><a href="">霉霉那些好听的歌</a></p>
                <p>播放量: 203.7万</p>
            </li>
            <li><a href="trendingRecFrame.do"><span><img id='pic' src="images/h.png"><img src="images/hp3.png"></span></a><span></span>
                <p><a href="">『独家欧美』晚风踩着云朵贩卖爱</a></p>
                <p>播放量: 423.1万</p>
            </li>
            <li><a href="trendingRecFrame.do"><span><img id='pic' src="images/h.png"><img src="images/hp4.jfif"></span></a><span></span>
                <p><a href="">500首轻音 学渣听了也想考北大</a></p>
                <p>播放量: 875.2万</p>
            </li>
            <li><a href="trendingRecFrame.do"><span><img id='pic' src="images/h.png"><img src="images/hp5.jfif"></span></a><span></span>
                <p><a href="">故事落幕 有些话 你不说我也懂</a></p>
                <p>播放量: 124.6万</p>
            </li>


        </ul>

    </div>
    <div id="navdian">

        <a href="#" class="nav1">
            <span class="navx"></span>
        </a>

        <a href="#" class="nav1">
            <span class="navx"></span>
        </a>
        <a href="" class="nav1">
            <span class="navx"></span>
        </a>
    </div>
</div>

<!-- 第四张 -->
<div id="fourmain">
    <input id="left4" type="image" src="images/left.png" name="mainboth" />
    <input id="right4" type="image" src="images/right.png" name="mainboth" />
    <div id="title">
        <span>新</span><span>碟</span><span>首</span><span>发</span>

    </div>
    <div id="fourlun">
        <ul>
            <li><a style="color:#7dd1a9;">内地</a></li>
            <li><a href="">港台</a></li>
            <li><a href="">欧美</a></li>
            <li><a href="">韩国</a></li>
            <li><a href="">日本</a></li>
            <li><a href="">其他</a></li>
            <li><a href="">更多 ></a></li>
        </ul>
        <div id="fourlun">
            <dl>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=461080452.mp3&songId=252&songName=认真地老去"><span class="box4"><img id='box4' src="images/p1.jpg"><img class='bic'
                                                                                          src="images/h.png"></span></a>
                    <p>
                        <a href="">浙音乐师生演唱创作作品系列EP专辑(一)</a><br>
                        <a href="">庞龙「高睿/万羽翼/朱天添 </a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=1881103386.mp3&songId=243&songName=酌酒醉长安"><span class="box4"><img id='box4' src="images/p2.jpg"><img class='bic'
                                                                                  src="images/h.png"></span></a>
                    <p>
                        <a href="">酌酒醉长安</a><br>
                        <a href="">七叔(叶泽浩)</a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=25641522.mp3&songId=244&songName=原罪" ><span class="box4"><img id='box4' src="images/p3.jpg"><img class='bic'
                                                                                                                                                    src="images/h.png"></span></a>
                    <p>
                        <a href="">原罪</a><br>
                        <a href="">邢万来(Ava) </a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=1475968736.mp3&songId=246&songName=半步沉香"> <span class="box4"><img id='box4' src="images/p4.jpg"><img class='bic'
                                                                                           src="images/h.png"></span></a>
                    <p>
                        <a href="">半步沉香</a><br>
                        <a href="">苏紫 </a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=1482698147.mp3&songId=247&songName=很喜欢"><span class="box4"><img id='box4' src="images/p5.jpg"><img class='bic'
                                                                                  src="images/h.png"></span></a>
                    <p>
                        <a href="">很喜欢</a><br>
                        <a href="">刘瑞琦 </a>
                    </p>
                </dd>
            </dl>
            <dl>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=1849170102.mp3&songId=248&songName=喜糖"> <span class="box4"><img id='box4' src="images/p6.jpg"><img class='bic'
                                                                                  src="images/h.png"></span></a>
                    <p>
                        <a href="">喜糖</a><br>
                        <a href="">毛姗瞳 </a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=293976.mp3&songId=253&songName=21克"> <span class="box4"><img id='box4' src="images/p7.jpg"><img class='bic'
                                                                                           src="images/h.png"></span></a>
                    <p>
                        <a href="">21克</a><br>
                        <a href="">毛雨张 </a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=1925782110.mp3&songId=249&songName=黑夜陷阱"><span class="box4"><img id='box4' src="images/p8.jpg"><img class='bic'
                                                                                  src="images/h.png"></span></a>
                    <p>
                        <a href="">黑夜陷阱</a><br>
                        <a href="">秦尾巴</a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=5245624.mp3&songId=250&songName=退路"><span class="box4"><img id='box4' src="images/p9.jpg"><img class='bic'
                                                                                  src="images/h.png"></span></a>
                    <p>
                        <a href="">退路</a><br>
                        <a href="">刘端端</a>
                    </p>
                </dd>
                <dd><a href="play.do?songAddress=http://music.163.com/song/media/outer/url?id=25906124.mp3&songId=251&songName=不要说话"><span class="box4"><img id='box4' src="images/p10.jpg"><img class='bic'
                                                                                   src="images/h.png"></span></a>
                    <p>
                        <a href="">必须课</a><br>
                        <a href="">刘润泽</a>

                    </p>

                </dd>
            </dl>

            <div id="navdian">

                <a href="#" class="nav">
                    <span class="navx"></span>
                </a>

                <a href="#" class="nav">
                    <span class="navx"></span>
                </a>
            </div>
        </div>
    </div>
</div>
<!-- 页面底部 -->
<div class="footer" style="visibility: visible;">
    <p class="friendly-links">
        关于狗眼 :
        <a href="#" target="_blank">关于我们</a>
        <span></span>
        <a href="#" target="_blank">管理团队</a>
        <span></span>
        <a href="#" target="_blank">投资者关系</a> &nbsp;&nbsp;&nbsp;&nbsp; 友情链接 :
        <a href="#" data-query="utm_source=wwwmaoyan" target="_blank">美团网</a>
        <span></span>
        <a href="#" data-query="utm_source=wwwmaoyan">格瓦拉</a>
        <span></span>
        <a href="#" data-query="utm_source=wwwmaoyan" target="_blank">美团下载</a>
        <span></span>
        <a href="#" data-query="utm_source=maoyan_pc" target="_blank">欢喜首映</a>
    </p>
    <p class="friendly-links">
        商务合作邮箱：v@maoyan.com 客服电话：10105335 违法和不良信息举报电话：4006018900
    </p>
    <p class="friendly-links">
        用户投诉邮箱：tousujubao@meituan.com 舞弊线索举报邮箱：wubijubao@maoyan.com
    </p>
    <p class="friendly-links  credentials">
        <a href="#" target="_blank">中华人民共和国增值电信业务经营许可证 京B2-20190350</a>
        <span></span>
        <a href="#" target="_blank">营业性演出许可证 京演（机构）（2019）4094号</a>
    </p>
    <p class="friendly-links  credentials">
        <a href="#" target="_blank">广播电视节目制作经营许可证 （京）字第08478号</a>
        <span></span>
        <a href="#" target="_blank">网络文化经营许可证 京网文（2019）3837-369号 </a>
    </p>
    <p class="friendly-links  credentials">
        <a href="#" target="_blank">狗眼用户服务协议 </a>
        <span></span>
        <a href="#" target="_blank">狗眼平台交易规则总则 </a>
        <span></span>
        <a href="#" target="_blank">隐私政策 </a>
    </p>
    <p class="friendly-links  credentials">
        <a href="" target="_blank">京公网安备
            11010102003232号</a>
        <span></span>
        <a href="#/" target="_blank">京ICP备16022489号</a>
    </p>
    <p>北京狗眼文化有限公司</p>
    <p>
        ©<span class="my-footer-year">2020</span> 狗眼音乐 gouyan.com</p>
    <div class="certificate">
        <a href="#" target="_blank">
            <img src="images/bottom1.png">
        </a>
        <a href="#" target="_blank">
            <img src="images/bottom2.png">
        </a>
        <a href="h#" target="_blank">
            <img src="images/bottom3.png">
        </a>
    </div>
</div>


<script src="js/homepage.js"></script>
</body>
</html>
