<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/16
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
    $(document).ready(function(e) {
        $(".select1").uedSelect({
            width : 345
        });

    });


</script>
<script type="text/javascript">
    KE.show({id:"ecp",width:"800px",height:"300px"});
</script>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">用户管理</a></li>
        <li><a href="#">添加用户</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>基本信息</span></div>
    <input type="hidden" name="flag" value="addUser" >
    <ul class="forminfo">
        <form action="userManager.do" method="get">
            <input type="hidden" value="addUser" name="flag">
            <li>
                <label>用户邮箱</label>
                <input name="email" type="text" class="dfinput" />
            </li>

            <li>
                <label>用户密码</label>
                <input name="password" type="text" class="dfinput" /><i></i></li>

            <li>
                <label>用户名称</label>
                <input name="userName" type="text" class="dfinput" />
            </li>

            <li>
                <label>&nbsp;</label>
                <input  type="submit"  class="btn" value="确认保存" />
            </li>
        </form>

    </ul>
</div>

</div>
</body>
</html>
