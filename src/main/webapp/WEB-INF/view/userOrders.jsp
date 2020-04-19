<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tags:master pageTitle="Ваши заказы">
    <h2 align="center">Ваши заказы</h2><br>
    <c:if test="${param.success}">
        <div class="alert alert-success">Заказ успешно отменен</div>
    </c:if>
    <table class="table table-hover">
        <tr>
            <td>Статус</td>
            <td>Фильм</td>
            <td>Дата</td>
            <td>Время</td>
            <td>Места</td>
            <td>Действия</td>
        </tr>
        <c:forEach var="item" items="${orders}">
            <tr>
                <td>
                    <c:if test="${item.status=='Active'}">
                        <div  data-toggle="tooltip" data-placement="top" title="В процессе">
                            <img src="${pageContext.request.contextPath}/resources/images/info.png" width="40px">
                        </div>
                    </c:if>
                    <c:if test="${item.status=='Deprecated'}">
                        <div data-toggle="tooltip" data-placement="top" title="Прошел">
                            <img src="${pageContext.request.contextPath}/resources/images/success.jpg" width="40px">
                        </div>
                    </c:if>
                    <c:if test="${item.status=='Cancel'}">
                        <div data-toggle="tooltip" data-placement="top" title="Отменен">
                            <img src="${pageContext.request.contextPath}/resources/images/cancel.png" width="40px">
                        </div>
                    </c:if>
                </td>
                <td>${item.movie.name}</td>
                <td>${item.date}</td>
                <td>${item.time}</td>
                <td>${item.seat}</td>
                <td>
                    <c:if test="${item.status=='Active'}">
                        <form action="${pageContext.request.contextPath}/deleteOrder/${item.id}">
                            <button type="submit" class="btn btn-danger">Отменить заказ</button>
                        </form>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</tags:master>