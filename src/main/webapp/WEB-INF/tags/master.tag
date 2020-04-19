<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>

<html>
<head>
    <title>${pageTitle}</title>
    <meta charset="UTF-8">
    <tags:head/>
</head>
<body style="background-image: url('https://images.wallpaperscraft.ru/image/fon_nerovnosti_svet_86951_1920x1080.jpg')">
<div class="header-container">
    <div style="display: flex; width: 75%">
        <div class="header-button"><a class="link-header" href="${pageContext.servletContext.contextPath}/">На
            главную</a>
        </div>
        <div class="header-button"><a class="link-header"
                                      href="${pageContext.servletContext.contextPath}/poster">Афиша</a>
        </div>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <div class="row">
            <form class="my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/login">
                    <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                    <button class="btn btn-outline-info my-2 my-sm-0 mr-5" type="submit">Search</button>--%>
                <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="submit">Вход</button>
            </form>
            <form class="my-2 my-lg-0" action="${pageContext.servletContext.contextPath}/registration">
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
                <div class="dropdown-item" style="display: flex; justify-content: flex-start; height: 35px; align-content: center">
                    <div><img src="${pageContext.request.contextPath}/resources/images/ticket.png" height="30px"></div>
                    <div>
                        <form:form action="${pageContext.request.contextPath}/userOrders" method="POST">
                            <input style="padding: 5px" class="logout-button" type="submit" value="Мои заказы"/>
                        </form:form>
                    </div>
                </div>
                <div class="dropdown-item" style="display: flex; justify-content: flex-start; height: 35px; align-content: center">
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
<div class="main-container">
    <jsp:doBody/>
</div>
<article style="background: #4C4C4C" class="mb-3">
    <div class="card-body text-center">
        <h3 class="text-white mt-3">Курсавая работа</h3>
        <p class="h5 text-white">Created by Yaha and son</p>   <br>
        <p><a class="btn btn-warning w-25" target="_blank" href="https://github.com/YahaJava"> Github
            <i class="fa fa-window-restore "></i></a></p>
    </div>
    <br><br>
</article>
</body>
</html>