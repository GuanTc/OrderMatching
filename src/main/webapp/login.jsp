<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2019/8/6
  Time: 7:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

<div>
    ${msg}
</div>
<form id="register" action="${pageContext.request.contextPath }/user/login" method="post">
    <input type="text" placeholder="username" name="username" id="username"/>
    <input type="text" placeholder="password" name="password" id="password"/>
    <button type="submit" value="登陆" name="登陆">登陆</button>
</form>

ffffff
</body>
</html>
