<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/9/24
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示结果信息</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <%=request.getAttribute("info")%>
</body>
</html>
