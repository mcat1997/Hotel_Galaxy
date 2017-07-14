<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/14
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统-房间管理</title>
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
                <li><a href="/client_galaxy.jsp">用户信息管理</a> </li>
            </ul>
        </div>
    </div>
</nav>

<form class="form-horizontal" action="/bookRoomServlet" method="post">
    <h2 class="form-signin-heading">${info}</h2>
    <div class="form-group">
        <label for="inputCid" class="col-sm-2 control-label">身份证号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputCid" name="cId">
        </div>
    </div>
    <div class="form-group">
        <label for="inputCname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputCname" name="cName">
        </div>
    </div>
    <div class="form-group">
        <label for="inputCsex" class="col-sm-2 control-label">性别</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputCsex" name="cSex">
        </div>
    </div>
    <div class="form-group">
        <label for="inputCphone" class="col-sm-2 control-label">手机号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputCphone" name="cPhone">
        </div>
    </div>
    <div class="form-group">
        <label for="inputRNum" class="col-sm-2 control-label">房号</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputRNum" name="rNum">
        </div>
    </div>
    <div class="form-group">
        <label for="inputDateIn" class="col-sm-2 control-label">入住时间</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="inputDateIn" name="dateIn">
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