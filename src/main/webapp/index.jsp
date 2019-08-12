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
<form id="register" action="${pageContext.request.contextPath }/user/update" method="post">
    <input type="text" placeholder="userId" name="userId" />
    <input type="text" placeholder="username" name="username" />
    <input type="text" placeholder="password" name="password" />
    <input type="text" placeholder="name" name="name" />
    <button type="submit" value="确认修改" name="确认修改">确认修改</button>
</form>



index
</body>
</html>
