<%--
  Created by IntelliJ IDEA.
  User: xddn
  Date: 2020/9/27
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-2.0.3.js"></script>
    <script>
        $(function () {
            $("#btn1").click(function () {
                $.get("<%=application.getContextPath()%>/query",function (data) {
                    alert(data);
                });
            });

            $("#btn2").click(function () {
                $.post("<%=application.getContextPath()%>/query",{"account":"admin","password":"123456"},function (data) {
                    alert(data);
                });
            });

            $("#btn3").click(function () {

                $.get("<%=application.getContextPath()%>/query",function (data) {
                    alert("123");
                    // $("#myDiv").empty();
                    $.each(data,function (index,obj) {
                        $("#myDiv").append("<p>"+obj.name+"----"+obj.price+"</p>");
                    })
                });
            });

        });
    </script>
</head>
<body>
<button id="btn1">按钮1</button>
<button id="btn2">按钮2</button>
<button id="btn3">按钮3</button>
<div id="myDiv"></div>
</body>
</html>
