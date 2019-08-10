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
    <form id="addBuyOrderBook" action="${pageContext.request.contextPath }/BuyOrderBook/add" method="post">
        <input type="text" placeholder="请输入数量" name="buySize" id="buySize"/>
        <input type="text" placeholder="请输入价格" name="buyPrice" id="buyPrice"/>
        <button type="submit" value="提交" name="提交">提交</button>
    </form>


    <form id="deleteBuyOrderBook" action="${pageContext.request.contextPath }/BuyOrderBook/delete" method="post">
        <input type="text" placeholder="请输入id" name="id" id="id"/>
        <button type="submit" value="删除" name="删除">删除</button>
    </form>
</head>
<body>
ffffff
</body>
</html>
