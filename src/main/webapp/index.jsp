<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/12
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#eee">
<%--<c:if test="${empty username}">--%>
    <%--<c:redirect url="http://localhost:8080/hgjh"></c:redirect>--%>
<%--</c:if>--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">Galaxy酒店管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="nav navbar-nav"><a href="/login_galaxy.jsp">登录</a></li>
                <li><a href="/room_galaxy">客房管理</a></li>
                <li><a href="/client_galaxy.jsp">用户信息管理</a> </li>
            </ul>
        </div>
    </div>
</nav>
<div style="width: 30%;margin-right: auto;margin-left: auto;margin-top: 10%">
    <h1 style="text-align: center">欢迎光临</h1>
    <h2 style="text-align: center">Galaxy酒店管理系统</h2>
</div>
</h1>

<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>