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
    <form id="register" action="${pageContext.request.contextPath }/user/register" method="post">
        <input type="text" placeholder="username" name="username" id="username"/>
        <input type="text" placeholder="password" name="password" id="password"/>
        <input type="text" placeholder="name" name="name" id="name"/>
        <button type="submit" value="注册提交" name="注册提交">提交</button>
    </form>


    <form id="delete" action="${pageContext.request.contextPath }/BuyOrderBook/delete" method="post">
        <input type="text" placeholder="请输入id" name="id" id="id"/>
        <button type="submit" value="删除" name="删除">删除</button>
    </form>


    <form id="login" action="${pageContext.request.contextPath }/BuyOrderBook/delete" method="post">
        <input type="text" placeholder="请输入id" name="id" id="id"/>
        <button type="submit" value="删除" name="删除">删除</button>
    </form>

    <form id="update" action="${pageContext.request.contextPath }/BuyOrderBook/delete" method="post">
        <input type="text" placeholder="请输入id" name="id" id="id"/>
        <button type="submit" value="删除" name="删除">删除</button>
    </form>
</head>
<body>
ffffff
</body>
</html>
