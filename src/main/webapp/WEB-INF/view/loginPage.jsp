<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/infoPage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/poster.css">
    <script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


</head>
<body style="background-image: url('https://images.wallpaperscraft.ru/image/fon_nerovnosti_svet_86951_1920x1080.jpg')">
<div >
    <div id="loginbox" class = "w-25" style="margin: 200px 400px 0 550px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Вход в аккаунт</div>
            </div>
            <div style="padding-top: 30px" class="panel-body">
                <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                           method="POST" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <c:if test="${param.error != null}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        Неправильный логин или пароль
                                    </div>
                                </c:if>
                                <!--
                                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                    You have been logged out.
                                </div>
                                -->
                            </div>
                        </div>
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="username" placeholder="username" class="form-control">
                    </div>
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" placeholder="password" class="form-control">
                    </div>
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-success">Вход</button>
                        </div>
                        <div class="col-sm-6 controls">
                            Нет аккаунта, <a href="${pageContext.servletContext.contextPath}/registration">зарегистрируйтесь</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
