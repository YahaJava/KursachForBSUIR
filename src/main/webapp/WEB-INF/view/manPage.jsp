<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="${man.name}">
    <div class="container-film">
        <div>  <img src="${man.photo}" height="400px"> </div>
        <div class = "info">
            <div class="title">${man.name} ${man.surname}</div>
            <div class="info-item">Карьера: ${man.career} </div>
            <div class="info-item">Место рождения: ${man.birthPlace} </div>
            <div class="info-item">Год рождения: ${man.birthDate} </div>
        </div>
    </div><br>
  <c:forEach var="movie" items="${man.movies}">
        <a href="<c:url value="/film/${movie.id}"/>">
            <img src="${movie.posterURL}" height="250px"><br>
            <p>${movie.name}</p>
        </a>
  </c:forEach>
</tags:master>