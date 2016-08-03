<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Crear Usuario"/>
<template:login htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <div class="mdl-grid--no-spacing">
        <form:form method="post" modelAttribute="userDto" action="/login/add"
                   cssClass="mdl-cell mdl-cell--12-col">
            <div class="mdl-cell mdl-cell--12-col form" style="float: left">
                <h3>Datos de Usurio</h3>
                <!-- Nombre -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="name" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="name">Nombre</label>
                    <form:label path="name" cssClass="">
                        <form:errors path="name" cssClass=""/>
                    </form:label>
                </div>
                <!-- surName -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="surname" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="surname">Apellidos</label>
                    <form:label path="surname" cssClass="">
                        <form:errors path="surname" cssClass=""/>
                    </form:label>
                </div>
                <!-- height -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="height" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="height">Estatura (CM)</label>
                    <form:label path="height" cssClass="">
                        <form:errors path="height" cssClass=""/>
                    </form:label>
                </div>
                <!-- weight -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="weight" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="weight">Peso (Kg)</label>
                    <form:label path="weight" cssClass="">
                        <form:errors path="weight" cssClass=""/>
                    </form:label>
                </div>
                <!-- email -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="email" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="email">Email</label>
                    <form:label path="email" cssClass="">
                        <form:errors path="email" cssClass=""/>
                    </form:label>
                </div>
                <!-- Password -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="password" type="password"
                                cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="password">Password</label>
                    <c:if test="${passErr==1}">
                        <form:label path="password" cssClass="">
                            Error Las contraseñas no coinciden
                        </form:label>
                    </c:if>
                    <form:label path="password" cssClass="">
                        <form:errors path="password" cssClass=""/>
                    </form:label>
                </div>
                <!-- Repetir Password -->
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                    <form:input path="repeatPassword" type="password"
                                cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="repeatPassword">Repetir Password</label>
                    <c:if test="${passErr==1}">
                        <form:label path="repeatPassword" cssClass="">
                            Error Las contraseñas no coinciden
                        </form:label>
                    </c:if>
                    <form:label path="repeatPassword" cssClass="">
                        <form:errors path="repeatPassword" cssClass=""/>
                    </form:label>
                </div>
                <div class="componetsInput">
                    <label>Fecha de nacimiento</label>
                    <form:input type="date" path="birthday" style="width: 30%; margin: 5%"/>
                </div>
            </div>

            <input type="submit" value="Registrarse"
                   class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"
                   style="width: 30%; margin: 5%">
            </div>
        </form:form>
    </jsp:body>
</template:login>
