<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<tags:master pageTitle="Главная">
    <h1 align="center" style="margin-bottom: 30px">Сейчас популярны</h1>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <c:forEach begin="2" var="i" end="${mainMovies.size()}">
            <li data-target="#myCarousel" data-slide-to="${i}"></li>
            </c:forEach>
        </ol>

        <!-- Wrapper for slides -->

        <div class="carousel-inner">
            <div class="item active">
                <a href="<c:url value="/film/${mainMovies.get(0).id}"/>"><img style="height: 600px" src="${mainMovies.get(0).posterOnMainPage}" alt="${mainMovies.get(0).name}"></a>
            </div>
            <c:forEach begin="1" var="movie" items="${mainMovies}">
                <div class="item">
                    <a href="<c:url value="/film/${movie.id}"/>"><img style="height: 600px" src="${movie.posterOnMainPage}" height="700px" alt="${movie.name}"></a>
                </div>
            </c:forEach>
        </div>


        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <a href="<c:url value="/poster"/>"><h3 align="center" style="margin-top: 30px;: ">Смотреть больше фильмов</h3>
    </a>
</tags:master>
