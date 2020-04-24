<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="${movie.name}">
    <div>
        <div class="container">
            <div class="image-container">
                <img src="${movie.posterURL}" height="400px">
                <form action="${pageContext.request.contextPath}/buy/date/${movie.id}">
                    <button style="width: 100%" type="submit" class="mt-4 btn btn-primary" data-toggle="modal"
                            data-target="#exampleModalCenter">
                        Купить Билет
                    </button>
                </form>
            </div>
            <div class="info-container">
                <div class="name">
                    <p><b>${movie.name}</b></p>
                </div>
                <div class="genre">
                    <p><b>Жанр:</b> ${movie.genre}</p>
                </div>
                <div class="director">
                    <p><b>Режисёр:</b> <a
                            href="<c:url value="/director/${movie.director.id}"/>">${movie.director.name} ${movie.director.surname}</a>
                    </p>
                </div>
                <div class="year">
                    <p><b>Год выпуска:</b> ${movie.year}</p>
                </div>
                <div>
                    <p><b>Страна:</b> ${movie.country}</p>
                </div>
                <div class="budget">
                    <p><b>Бюджет:</b> ${movie.budget}</p>
                </div>
                <div class="actors">
                    <p><b>В главных ролях:</b>
                        <c:forEach var="actor" items="${movie.actors}">
                            <a href="<c:url value="/actor/${actor.id}"/>">${actor.name} ${actor.surname}</a>
                        </c:forEach>
                    </p>
                </div>
                <div class="description">
                    <b>Описание:</b><br>
                    <p>${movie.description}</p>
                </div>
            </div>
        </div>
        <hr>
    </div>

</tags:master>