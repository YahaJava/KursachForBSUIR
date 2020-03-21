<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="${movie.name}">
    <div class="container-film">
        <div>  <img src="${director.photo}" height="400px"> </div>
        <div class = "info">
            <div class="title">${director.name} ${director.surname}</div>
            <div class="info-item">Карьера: ${director.career} </div>
            <div class="info-item">Место рождения: ${director.birthPlace} </div>
            <div class="info-item">Год рождения: ${director.birthDate} </div>
        </div>
    </div><br>
  <c:forEach var="movie" items="${director.movies}">
        <a a href="<c:url value="/film/${movie.id}"/>">
            <img src="${movie.posterURL}" height="250px"><br>
            <p>${movie.name}</p>
        </a>
    </c:forEach>
</tags:master>