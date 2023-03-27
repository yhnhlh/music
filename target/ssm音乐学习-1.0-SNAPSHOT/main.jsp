<%--
  Created by IntelliJ IDEA.
  User: 33538
  Date: 2022/6/16
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息管理系统界面</title>
</head>
<frameset rows="*,31" cols="*" frameborder="no" border="0" framespacing="0">
    <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
        <frame src="left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
        <frame src="index2.jsp" name="rightFrame" id="rightFrame" title="rightFrame" />
    </frameset>
    <frame src="footer.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />
</frameset>
<noframes><body>
</body></noframes>
</html>
