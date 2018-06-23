<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/15
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统-allert</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body style="background-color:#eee">
<%--<c:if test="${empty username}">--%>
<%--<c:redirect url="http://localhost:8080/login_galaxy.jsp"></c:redirect>--%>
<%--</c:if>--%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">Galaxy酒店管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="/login_galaxy.jsp">登录</a></li>
                <li><a href="/room_galaxy">客房管理</a></li>
                <li class="active"><a href="/room_add_galaxy.jsp">客房增加</a></li>
                <li><a href="/customer_galaxy">用户信息管理</a></li>
                <li><a href="/checkinout_galaxy">订单管理</a></li>
            </ul>
        </div>
    </div>
</nav>
<form class="form-horizontal" action="/addRoomServlet" method="post">
    <h2 class="form-signin-heading">${info}</h2>
    <div class="form-group">
        <label for="inputRNum" class="col-sm-2 control-label">房号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputRNum" name="rNum">
        </div>
    </div>
    <div class="form-group">
        <label for="inputRType" class="col-sm-2 control-label">房间类型</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputRType" name="rType">
        </div>
    </div>

    <div class="form-group">
        <label for="inputRPrice" class="col-sm-2 control-label">每日价格</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputRPrice" name="rPrice">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">录入</button>
        </div>
    </div>
</form>

<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>