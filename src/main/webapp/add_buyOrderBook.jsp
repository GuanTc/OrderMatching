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
<form id="buyOrderBookadd" action="${pageContext.request.contextPath }/buyOrderBook/add" method="post">
    <input type="text" placeholder="stockId" name="stockId"/>
    <input type="text" placeholder="orderId" name="orderId" />
    <input type="text" placeholder="buySize" name="buySize" />
    <input type="text" placeholder="buyPrice" name="buyPrice" />
    <button type="submit" value="add" name="add">add</button>
</form>
</br>------------------------------------------------------</br>
<form id="buyOrderBookfindAll" action="${pageContext.request.contextPath }/buyOrderBook/findAll" method="post">
    <button type="submit" value="findAll" name="findAll">findAll</button>
</form>
</br>------------------------------------------------------</br>

<form id="buyOrderBookupdate" action="${pageContext.request.contextPath }/buyOrderBook/update" method="post">
    <input type="text" placeholder="bobId" name="bobId" />
    <input type="text" placeholder="stockId" name="stockId" />
    <input type="text" placeholder="orderId" name="orderId" />
    <input type="text" placeholder="buySize" name="buySize" />
    <input type="text" placeholder="buyPrice" name="buyPrice" />
    <button type="submit" value="update" name="update">update</button>
</form>
</br>------------------------------------------------------</br>
<form id="buyOrderBookdelete" action="${pageContext.request.contextPath }/buyOrderBook/delete" method="post">
    <input type="text" placeholder="bobId" name="bobId" />
    <button type="submit" value="delete" name="delete">delete</button>
</form>
</br>------------------------------------------------------</br>

<form id="buyOrderBookfindMaxPrice" action="${pageContext.request.contextPath }/buyOrderBook/findMaxPrice" method="post">
    <input type="text" placeholder="stockId" name="stockId" />
    <button type="submit" value="findMaxPrice" name="findMaxPrice">findMaxPrice</button>
</form>
</br>------------------------------------------------------</br>

</body>
</html>
