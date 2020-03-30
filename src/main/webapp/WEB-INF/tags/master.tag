<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>

<html>
<head>
    <title>${pageTitle}</title>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css?family=Roboto:500&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/moviePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/poster.css">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
</head>
<body>
<div class="main-container">
    <div class="header-container">
        <div class="header-button"><a class="link-header" href="${pageContext.servletContext.contextPath}/">На
            главную</a>
        </div>
        <div class="header-button"><a class="link-header"
                                      href="${pageContext.servletContext.contextPath}/poster">Афиша</a>
        </div>
        <sec:authorize access="!isAuthenticated()">
            <div class="row">
                <form class="my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/login">
                        <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-info my-2 my-sm-0 mr-5" type="submit">Search</button>--%>
                    <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="submit">Вход</button>
                </form>
                <form class="my-2 my-lg-0">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Регистрация</button>
                </form>
            </div>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <sec:authentication property="principal.username" var="username"/>
            <div class="dropdown">
                <button class="btn btn-success dropdown-toggle" style="width: 200px" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${username}
                </button>
                <div class="dropdown-menu" style="width: 200px" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-item" style="display: flex; justify-content: space-between; height: 35px; align-content: center">
                        <div><img src="${pageContext.request.contextPath}/resources/images/logout.png" height="30px"></div>
                        <div>
                            <form:form action="${pageContext.request.contextPath}/logout" method="POST">
                                <input style="padding: 5px" class="logout-button" type="submit" value="Выйти из аккаунта"/>
                            </form:form>
                        </div>


                    </div>

                </div>
            </div>
        </sec:authorize>
    </div>

    <jsp:doBody/>
</div>

</body>
</html>