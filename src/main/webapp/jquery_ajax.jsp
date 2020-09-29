<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/27
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=application.getContextPath()%>/js/jquery-2.0.0.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.get("<%=application.getContextPath()%>/jquery",function (data) {
                    alert(data)
                });
            });
            $("#btn2").click(function () {
                $.getJSON("<%=application.getContextPath()%>/jquery",function (data) {
                    $("#myDiv").empty();
                    $.each(data,function (index,obj) {
                        $("#myDiv").append("<p>"+obj.ename+"---"+obj.sal+"<p>");
                    })
                });
            });
            $("myForm").submit(function () {
                var data = $("myForm").serializaArry();
                var s =  JSON.stringify(data);
                $("myDiv").empty().text(s);
                $.each(data,function (index,obj) {
                    $("myDiv").append("<p>"+obj.ename+"---"+obj.sal+"<p>");
                })
                return false;
            });
        })
    </script>
</head>
<body>
    <button id="btn">1</button>
    <button id="btn2">2</button>
    <button id="btn3">3</button>
<div id="myDiv"></div>
    <form action="#" method="post" id="myForm">\
<input type="text" name="account" placeholder="请输入用户名"><br>
    <input type="password" name="password" placeholder="请输入用户名"><br>
    <input type="datetime-local" name="time" placeholder="请输入用户名"><br>
    <input type="number" name="num" placeholder="请输入年龄"><br>
    <input type="radio" name="sex" value="man">男<br>
    <input type="radio" name="sex" value="woman">女<br>
    <input type="checkbox" name="honny" value="trip"><br>
    <input type="checkbox" name="honny" value="play"><br>
    <input type="checkbox" name="honny" value="sa"><br>
    <input type="checkbox" name="honny" value="sdasdwas"><br>
    <input type="submit" value="提交">
    </form>
</body>
</html>
