<%--
  Created by IntelliJ IDEA.
  User: ZZY
  Date: 2020/9/28
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            margin: auto;
            text-align: center;
            border-collapse: collapse;
        }

        table,th,td{
            border: 1px solid black;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>图片</th>
            <th>价格</th>
        </tr>
        <c:forEach items="${all}" var="g">
            <tr>
                <th>${g.id}</th>
                <th>${g.name}</th>
                <th><img src="<%=application.getContextPath()%>/${g.image}" width="200"></th>
                <th>${g.price}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
