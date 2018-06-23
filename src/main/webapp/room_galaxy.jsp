<%--
  Created by IntelliJ IDEA.
  User: a3899
  Date: 2017/7/12
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Galaxy酒店管理系统-房间管理</title>
    <link href="//cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript">
        function bookClick() {
            this.location.href = "bookRoom_Galaxy.jsp?rNum=${room.rnum}";
        }
    </script>
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
                <li class="active"><a href="/room_galaxy">客房管理</a></li>
                <li><a href="/room_add_galaxy.jsp">客房增加</a></li>
                <li><a href="/customer_galaxy">用户信息管理</a></li>
                <li><a href="/checkinout_galaxy">订单管理</a></li>
            </ul>
        </div>
    </div>
</nav>

<table class="table table-hover">
    <tr>
        <td>房间号</td>
        <td>房间类型</td>
        <td>房价/天</td>
        <td>房间状态</td>
        <td>退/订房</td>
        <td>编辑</td>
        <td>删除</td>
    </tr>
    <c:forEach var="room" items="${roomList}">
        <tr>
            <td>${room.rNum}</td>
            <td>${room.rType}</td>
            <td>${room.rPrice}</td>
            <td>
                <c:if test="${room.rState==true}">
                    未订出
                </c:if>
                <c:if test="${room.rState==false}">
                    已订出
                </c:if>
            </td>
            <td>
                <c:if test="${room.rState==true}">
                    <button type="button" class="btn btn-primary"
                            onclick="location='bookRoom_Galaxy.jsp?rNum=${room.rNum}'">
                        订房
                    </button>
                </c:if>
                <c:if test="${room.rState==false}">
                    <button type="button" class="btn btn-primary"
                            onclick="location='leaveRoom_Galaxy.jsp?rNum=${room.rNum}'">
                        退房
                    </button>
                </c:if>
            </td>
            <td>
                <c:if test="${room.rState==true}">
                    <button type="button" class="btn btn-primary"
                            onclick="location='editRoom_Galaxy.jsp?rNum=${room.rNum}'">
                        编辑
                    </button>
                </c:if>
            </td>
            <td>
                <c:if test="${room.rState==true}">
                    <button type="button" class="btn btn-primary" onclick="location='delRoom_Galaxy?rNum=${room.rNum}'">
                        删除
                    </button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>


<script src="//cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
