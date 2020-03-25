<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="${movie.name}">
    <div class="container-film">
        <div>  <img src="${movie.posterURL}" height="400px"> </div>
        <div class = "info">
            <div class="title">${movie.name}</div>
            <div class="info-item">Жанр: ${movie.genre} </div>
            <div class="info-item">Режиссер: <a href="<c:url value="/director/${movie.director.id}"/>">${movie.director.name} ${movie.director.surname}</a></div>
            <div class="info-item">В главных ролях:
                <c:forEach var="actor" items="${movie.actors}">
                    <a href="<c:url value="/actor/${actor.id}"/>">${actor.name} ${actor.surname}</a>
                </c:forEach>
            </div>
            <div class="info-item">Страна: ${movie.country} </div>
            <div class="info-item">Год выпуска: ${movie.year} </div>
            <div class="info-item">Бюджет: ${movie.budget} </div>
        </div>
    </div>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">
        Купить Билет
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Купить билет ${movie.name}</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:forEach var="i" begin="1" end="5">
                        <c:forEach var="i" begin="1" end="15">
                            <div class="seat-empty"></div>
                        </c:forEach><br>
                    </c:forEach>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
                    <button type="button" class="btn btn-primary">Купить</button>
                </div>
            </div>
        </div>
    </div>
</tags:master>