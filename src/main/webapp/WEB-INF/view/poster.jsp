<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Афиша">
    <h2 style="margin-bottom: 30px" align="center">Cейчас в прокате</h2>
    <div class="row">
        <c:forEach var="movie" items="${movies}">
            <div style="width: 220px; border: none; margin: 20px 0 0 60px;">
                <a href="<c:url value="/film/${movie.id}"/>">
                    <img src="${movie.posterURL}" class="card-img-top" style="height: 320px;">
                </a>
                <div>
                    <a class="link ml-1" style="font-size: 18px; font-weight: 600"
                       href="<c:url value="/film/${movie.id}"/>">${movie.name}</a>
                    <p class="ml-1" style="font-size: 16px; color: #6c757d">${movie.genre}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</tags:master>

