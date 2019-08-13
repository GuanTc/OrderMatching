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
<form id="add" action="${pageContext.request.contextPath }/stock/add" method="post">
    <input type="text" placeholder="stockCode" name="stockCode" />
    <input type="text" placeholder="stockName" name="stockName"/>
    <button type="submit" value="add" name="add">add</button>
</form>
</br>------------------------------------------------------</br>
<form id="findAll" action="${pageContext.request.contextPath }/stock/findAll" method="post">
    <button type="submit" value="findAll" name="findAll">findAll</button>
</form>
</br>------------------------------------------------------</br>
<form id="search" action="${pageContext.request.contextPath }/stock/search" method="post">
    <input type="text" placeholder="stockCode" name="stockCode" />
    <button type="submit" value="search" name="search">search</button>
</form>
</br>------------------------------------------------------</br>
</body>
</html>
