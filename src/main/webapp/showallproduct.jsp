<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-2.0.3.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"<%=application.getContextPath()%>/product?op=like",
                    type:"post",
                    data:{
                        "name":$("#name").val(),
                    },
                    success:function (data) {
                        var arr = JSON.parse(data);
                        var tr1 =$("#myTb").append("#trr");
                        $("#myTb").empty();
                        $("#myTb").append(tr1);
                        $.each(arr,function (index,obj) {
                            $("#myTb").append(
                                "<tr>"+
                                "<td>"+obj.id+"</td>"+
                                "<td>"+obj.name+"</td>"+
                                "<td>"+obj.description+"</td>"+
                                "<td>"+obj.price+"</td>"+
                                "<td>"+obj.stock+"</td>"+
                                "<td><button>编辑</button><button>删除</button></td>"+
                                "</tr>"
                            );
                        })
                    },
                    error:function (e) {
                        alert("获取数据失败")
                    }
                });
            });
        })
    </script>
</head>
<body>
<table id="myTb">
    <input type="text" id="name" placeholder="请输入一个关键名称">
    <button id="btn">查询</button>
    <tr id="trr">
        <th>产品编号</th>
        <th>产品名称</th>
        <th>产品描述</th>
        <th>产品价格</th>
        <th>产品库存</th>
    </tr>
</table>
</body>
</html>
