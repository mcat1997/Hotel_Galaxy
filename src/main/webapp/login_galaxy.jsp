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
    <title>Galaxy酒店管理系统-登录</title>


    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>

<body >
<%--<form action="/login_galaxy" method="post">--%>
    <%--<input type="text" name="username"/>--%>
    <%--<input type="password" name="password"/>--%>
    <%--<input type="submit"/>--%>
<%--</form>--%>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">Galaxy酒店管理系统</a>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/login_galaxy.jsp">登录</a></li>
                <li><a href="/room_galaxy">客房管理</a></li>
                <li><a href="/customer_galaxy">用户信息管理</a> </li>
                <li><a href="/checkinout_galaxy">订单管理</a> </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container" >

    <div style="width: 30%;margin-left: auto;margin-right: auto;margin-top: 10%">
    <form class="form-signin" action="/login_galaxy" method="post">
        <h2 class="form-signin-heading">${info}</h2>
        <label for="username" class="sr-only">用户名</label>
        <input type="text" name="username" id="username" class="form-control" placeholder="username" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" name="password" id="password" class="form-control" placeholder="password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
    </div>
</div> <!-- /container -->
<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>