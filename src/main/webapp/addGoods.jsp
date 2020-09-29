<%--
  Created by IntelliJ IDEA.
  User: ZZY
  Date: 2020/9/28
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=application.getContextPath()%>/goods?op=add" method="post" enctype="multipart/form-data">
<input type="text" name="name" placeholder="请输入商品名称"><br>
    <input type="file" name="img" placeholder="请输入商品图片" multiple><br>
    <input type="number" name="price" placeholder="请输入商品价格"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
