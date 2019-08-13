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
<form id="add" action="${pageContext.request.contextPath }/Order/add" method="post">
    <input type="text" placeholder="userId" name="userId" />
    <input type="text" placeholder="stockId" name="stockId"/>
    <input type="text" placeholder="price" name="price" />
    <input type="text" placeholder="qty" name="qty" />
    <input type="text" placeholder="remainQty" name="remainQty" />
    <input type="text" placeholder="orderType" name="orderType" />
    <input type="text" placeholder="marketPrice" name="marketPrice" />
    <input type="text" placeholder="limitPrice" name="limitPrice" />
    <input type="text" placeholder="triggerPrice" name="triggerPrice" />
    <input type="text" placeholder="stopPrice" name="stopPrice" />
    <input type="text" placeholder="fullOrKill" name="fullOrKill" />
    <input type="text" placeholder="duration" name="duration" />
    <input type="text" placeholder="gtdDate" name="gtdDate" />
    <input type="text" placeholder="minute" name="minute" />
    <input type="text" placeholder="submitDate" name="submitDate" />
    <input type="text" placeholder="status" name="status" />
    <input type="text" placeholder="sendOutDate" name="sendOutDate" />
    <input type="text" placeholder="finalDate" name="finalDate" />
    <button type="submit" value="add" name="add">add</button>
</form>


<form id="findAll" action="${pageContext.request.contextPath }/Order/findAll" method="post">
    <button type="submit" value="findAll" name="findAll">findAll</button>
</form>

<form id="findOrdersByCondition" action="${pageContext.request.contextPath }/Order/findOrdersByCondition" method="post">
    <input type="text" placeholder="type" name="type" />
    <input type="text" placeholder="stockId" name="stockId" />
    <input type="text" placeholder="orderType" name="orderType" />
    <input type="text" placeholder="start" name="start" />
    <input type="text" placeholder="end" name="end" />
    <button type="submit" value="findOrdersByCondition" name="findOrdersByCondition">findOrdersByCondition</button>
</form>

</body>
</html>
