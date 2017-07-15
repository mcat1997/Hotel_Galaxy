<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/14
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统-用户管理</title>
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
                <li ><a href="/room_galaxy">客房管理</a></li>
                <li><a href="/room_add_galaxy.jsp">客房增加</a> </li>
                <li class="active" ><a href="/customer_galaxy">用户信息管理</a> </li>
                <li><a href="/checkinout_galaxy">订单管理</a> </li>
            </ul>
        </div>
    </div>
</nav>
    <table class="table table-hover">
        <tr>
            <td>身份证号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>手机号</td>
            <td>编辑</td>
            <td>删除</td>
        </tr>
        <c:forEach var="customer" items="${customerList}">
            <tr>
                <td>${customer.cId}</td>
                <td>${customer.cName}</td>
                <td>${customer.cSex}</td>
                <td>${customer.cPhone}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="location='editCustomer_Galaxy.jsp?cId=${customer.cId}'">
                        编辑
                    </button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="location='delCustomer_Galaxy?cId=${customer.cId}'">
                        删除
                    </button>
                </td>
            </tr>
        </c:forEach>
    </table>
<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>