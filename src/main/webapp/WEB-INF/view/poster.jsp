<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<tags:master pageTitle="Афиша">
    <table class="table table-hover container">
        <thead>
        <tr class="container">
            <td>Image</td>
            <td>Name</td>
            <td>Genre</td>
        </tr>
        </thead>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>
                    <img src="${movie.posterURL}" height="250px">
                </td>
                <td><a href="<c:url value="/film/${movie.id}"/>">${movie.name}</a></td>
                <td>${movie.genre}</td>
            </tr>
        </c:forEach>
    </table>
</tags:master>

