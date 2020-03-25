<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Афиша">
    <div>
        <c:forEach var="i"  begin="0" end="${movies.size()}" step="4">
            <div class="row">
                <c:forEach var="movie" begin="${i}" end="${i+3}" items="${movies}">
                    <div class="card ml-5 mb-4" style="width: 240px; border: none;">
                        <a href="<c:url value="/film/${movie.id}"/>">
                            <img src="${movie.posterURL}"  class="card-img-top" style="height: 360px;">
                        </a>
                        <div >
                            <a class="link ml-1" style="font-size: larger; font-weight: 500"  href="<c:url value="/film/${movie.id}"/>">${movie.name}</a>
                            <p class="ml-1" style="color: #6c757d">${movie.genre}</p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </div>


<%--
    <img src="${movie.posterURL}" height="250px">
    <a href="<c:url value="/film/${movie.id}"/>">${movie.name}</a>
    ${movie.genre}
--%>

</tags:master>

