
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=application.getContextPath()%>/goods?op=add" method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="输入名称"><br>
        <input type="file" name="img" placeholder="图片"><br>
        <input type="number" name="price" placeholder="价格"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
