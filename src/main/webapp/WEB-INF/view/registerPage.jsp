<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tags:master pageTitle="Registration">
    <div class="container">
        <form:form action="confirm" modelAttribute="user">
            <div class="form-group row">
                <label for="inputLogin" class="col-sm-2 col-form-label">Логин</label>
                <form:input path="login" type="text" class="form-control" id="inputLogin"/>
                <form:errors path="login" class="alert alert-danger"/>
            </div>

            <div class="form-group col-md-4">
                <label for="password">Пароль</label>
                <form:input type="password" cssclass="form-control" id="password" path="password"/>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="name">Имя</label>
                    <form:input type="text" cssclass="form-control" id="name" path="name"/>
                </div>
                <div class="form-group col-md-4">
                    <label for="surname">Фамилия</label>
                    <form:input type="text" cssclass="form-control" id="surname" path="surname"/>
                </div>
            </div>
            <div class="form-group col-md-5">
                <label for="mail">Эл. Почта</label>
                <form:input path="mail" type="text" cssclass="form-control" id="mail"/>
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
        </form:form>
    </div>

</tags:master>