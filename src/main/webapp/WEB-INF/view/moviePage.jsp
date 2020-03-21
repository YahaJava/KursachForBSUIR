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
            <div class="info-item">Страна: ${movie.country} </div>
            <div class="info-item">Год выпуска: ${movie.year} </div>
            <div class="info-item">Бюджет: ${movie.budget} </div>
        </div>
    </div>
</tags:master>