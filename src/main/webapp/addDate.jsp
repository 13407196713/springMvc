<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-07-11
  Time: 09:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/converter/date" method="post">
        日期：<input type="text" name="date" />(yyyy-MM-dd)<br/><!-- name 对应方法名 -->
        <input type="submit" value="提交">
    </form>
</body>
</html>
