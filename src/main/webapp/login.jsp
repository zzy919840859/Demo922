<%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/27
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=application.getContextPath()%>/admin?op=login" method="post">
    <input type="text" name="account" placeholder="请输入账号">
    <input type="password" name="password" placeholder="请输入密码">
    <input type="submit" value="登录">
</form>

</body>
</html>
