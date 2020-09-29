<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/24
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <form action="<%=application.getContextPath()%>/dept?op=addDept" method="post">
        <input type="text" name="deptno" placeholder="编号"><br>
        <input type="text" name="deptno" placeholder="名称"><br>
        <input type="text" name="deptno" placeholder="地点"><br>
        <input type="submit" value="添加部门">
    </form>
</body>
</html>
