<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="pageTitle" required="true" %>

<html>
<head>
    <title>${pageTitle}</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/moviePage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/poster.css">
    <script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.servletContext.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="main-container">
    <div class="header-container">
        <div class="header-button"><a class="link-header" href="${pageContext.servletContext.contextPath}/">На главную</a>
        </div>
        <div class="header-button"><a class="link-header" href="${pageContext.servletContext.contextPath}/poster">Афиша</a>
        </div>
        <div>
            <form class="form-inline my-2 my-lg-0">
                <%--<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-info my-2 my-sm-0 mr-5" type="submit">Search</button>--%>
                <button class="btn btn-outline-success my-2 my-sm-0 mr-1" type="submit">Вход</button>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Регистрация</button>
            </form>
        </div>
    </div>

    <jsp:doBody/>
</div>

</body>
</html>