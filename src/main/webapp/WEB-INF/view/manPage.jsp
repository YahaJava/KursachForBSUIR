<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="${man.name}">

    <div>
        <div class="container">
            <div class="image-container">
                <img src="${man.photo}" style="width:250px; height:360px">
            </div>
            <div class="info-container">
                <div class="name">
                    <p><b>${man.name} ${man.surname}</b></p>
                </div>
                <div class="genre">
                    <p><b>Карьера:</b> ${man.career}</p>
                </div>
                <div class="year">
                    <p><b>Место рождения:</b> ${man.birthPlace}</p>
                </div>
                <div>
                    <p><b>Год рождения: </b> ${man.birthDate}</p>
                </div>
            </div>
        </div><br>
        <hr>
        <h3 align="center">Фильмы:</h3>
        <div class="row">
            <c:forEach var="movie" items="${man.movies}">
                <a href="<c:url value="/film/${movie.id}"/>">
                    <div style="margin: 10px; display: flex; flex-direction: column; width: 170px">
                        <img src="${movie.posterURL}" height="250px"><br>
                        <p>${movie.name}</p>
                    </div>
                </a>
            </c:forEach>
        </div>

    </div>

</tags:master>