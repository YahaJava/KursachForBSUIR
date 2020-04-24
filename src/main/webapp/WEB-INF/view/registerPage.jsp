<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<tags:master pageTitle="Регистрация">

    <div class="card bg-light">
        <article class="card-body mx-auto w-50">
            <h2 class="card-title mt-3 text-center">Регистрация</h2>

            <form:form action="confirm" modelAttribute="user" class="mt-5">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text " style="height: 34px;"> <i class="fa fa-user"></i> </span>
                        <form:input class="form-control w-50" placeholder="Username" type="text" path="login"/>
                        <form:errors path="login" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                        <c:if test="${loginExist}">
                            <p style="max-height: 35px; margin-left: 10px; padding: 10px" class="alert-danger">Такой
                                логин уже есть</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        <form:input class="form-control w-50" placeholder="Имя" type="text" path="name"/>
                        <form:errors path="name" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                    </div>
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-user"></i> </span>
                        <form:input class="form-control w-50" placeholder="Фамилия" type="text" path="surname"/>
                        <form:errors path="surname" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                    </div>
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
                        <form:input class="form-control w-50" placeholder="Email address" type="email" path="mail"/>
                        <form:errors path="mail" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                    </div>
                </div>

                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" style="height: 34px;"> <i class="fa fa-lock"></i> </span>
                        <form:input class="form-control w-50" placeholder="Пароль" type="password" path="password"/>
                        <form:errors path="password" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                        <c:if test="${passwordMismatch}">
                            <p style="max-height: 35px; margin-left: 10px; padding: 10px" class="alert-danger">Пароли не
                                совпадают</p>
                        </c:if>
                    </div>
                </div>
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
                        <form:input class="form-control w-50" placeholder="Повторите пароль" type="password"
                                    path="passwordRepeat"/>
                        <form:errors path="passwordRepeat" style="max-height: 35px; margin-left: 10px; padding: 10px"
                                     class="alert-danger"/>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block">Зарегистрироваться</button>
                </div>
                <p class="text-center">Уже есть аккаунт? <a
                        href="${pageContext.servletContext.contextPath}/login">Войти</a></p>
            </form:form>
        </article>
    </div>
    </div>


</tags:master>