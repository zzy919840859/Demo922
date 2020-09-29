<%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/27
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%
    Object admin = session.getAttribute("admin");
    if (admin==null){
        request.setAttribute("message","请先登陆，在访问");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }
%>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${empty sessionScope.admin}">
    <a href="<%=application.getContextPath()%>/login.jsp"><button>登录</button></a>
</c:if>
<c:if test="${!empty sessionScope.admin}">
    ${admin.name}
    <a href="<%=application.getContextPath()%>/admin?op=reset">注销</a>
</c:if>
    当前访问人数是:${applicationScope.num}
</body>
</html>
