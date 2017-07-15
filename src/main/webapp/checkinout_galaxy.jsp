<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/14
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统-订单管理</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<c:if test="${empty username}">
    <c:redirect url="http://localhost:8080/login_galaxy.jsp"></c:redirect>
</c:if>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">Galaxy酒店管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li ><a href="/login_galaxy.jsp">登录</a></li>
                <li><a href="/room_galaxy">客房管理</a></li>
                <li><a href="/customer_galaxy">用户信息管理</a> </li>
                <li><a href="/checkinout_galaxy">订单管理</a> </li>
            </ul>
        </div>
    </div>
</nav>
<table class="table table-hover">
    <tr>
        <td>入住时间</td>
        <td>退房时间</td>
        <td>入住人身份证号</td>
        <td>入住房间</td>
        <td>总价格</td>
    </tr>
    <c:forEach var="checkinout" items="${checkinoutList}">
        <tr>
            <td>${checkinout.dateIn}</td>
            <td>${checkinout.dateOut}</td>
            <td>${checkinout.customer_galaxy.cId}</td>
            <td>${checkinout.room_galaxy.rnum}</td>
            <td>${checkinout.sumPrice}</td>
        </tr>
    </c:forEach>
</table>
<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
