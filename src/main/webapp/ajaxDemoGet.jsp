<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        var xhr;
        window.onload=function (ev) {
            document.getElementById("btn").onclick=function (ev1) {
                var info = document.getElementById("info").value;
                if (window.XMLHttpRequest){
                    xhr = new XMLHttpRequest();
                } else {
                    xhr = new ActiveXObject("Mirosoft.XMLHTTP");
                }
                xhr.onreadystatechange=  callback;
                xhr.open("get","<%=application.getContextPath()%>/ajax?info="+info,true);
                xhr.setRequestHeader("Content-Type","application/x-www-from-urlencoding");

                xhr.send("name=zhangsan&password=123456&info="+info);
            }
        }
        function callback() {
            if (xhr.readyState==4){
                if (xhr.status==200){
                    var s = xhr.responseText;
                    document.getElementById("myDiv").innerHTML=s;
                }
            }
        }
    </script>
</head>
<body>
    <input type="text" name="info" id="info">
    <button id="btn">我是按钮</button>
    <div id="myDiv">我是DIV</div>
<form action="" method="" enctype="application/x-www-form-urlencoded"></form>
</body>
</html>
