<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<template:main htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <c:choose>
            <c:when test="${editUser != 1}">
                <div class="mdl-grid--no-spacing">
                    <form:form method="post" modelAttribute="userAndProfileFormDto" action="/user/add"
                               cssClass="mdl-cell mdl-cell--12-col">
                        <h1>${title}</h1>
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
                                <label class="mdl-textfield__label" for="height">Estatura (M)</label>
                                <form:label path="height" cssClass="">
                                    <form:errors path="height" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- width -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="width" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="width">Peso (Kg)</label>
                                <form:label path="width" cssClass="">
                                    <form:errors path="width" cssClass=""/>
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
                                <form:label path="password" cssClass="">
                                    <form:errors path="password" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- Repetir Password -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="password" type="password"
                                            cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="password">Repetir Password</label>
                                <form:label path="password" cssClass="">
                                    <form:errors path="password" cssClass=""/>
                                </form:label>
                            </div>
                        </div>
                        <br>
                        <div class="mdl-cell mdl-cell--12-col form" style="float: left">
                            <h3>Datos de Perfil</h3>
                            <!-- Profile -->
                            <!-- carbs -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="carbs" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="carbs">HC</label>
                                <form:label path="carbs" cssClass="">
                                    <form:errors path="carbs" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- fat -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="fat" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="fat">Fat</label>
                                <form:label path="fat" cssClass="">
                                    <form:errors path="fat" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- protein -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="protein" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="protein">Proteina</label>
                                <form:label path="protein" cssClass="">
                                    <form:errors path="protein" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- fiber -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="fiber" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="fiber">Fibra</label>
                                <form:label path="fiber" cssClass="">
                                    <form:errors path="fiber" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- totalCalories -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="totalCalories" type="text"
                                            cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="totalCalories">Total de
                                    Calorias</label>
                                <form:label path="totalCalories" cssClass="">
                                    <form:errors path="totalCalories" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- timeDate -->
                            <form:input path="timeDate" type="date" cssClass="mdl-textfield__input" cssStyle="width: 60%; margin-left: 1%;"/>
                            <form:label path="timeDate" cssClass="">
                                <form:errors path="timeDate" cssClass=""/>
                            </form:label>
                            <input type="submit" value="Registrarse"
                                   class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect" style="width: 30%; margin-bottom: 5%; margin-top: 5%;">
                        </div>
                    </form:form>
                </div>
            </c:when>
            <c:otherwise>
                <div class="mdl-grid--no-spacing">
                    <form:form method="post" modelAttribute="userDto" action="/user/edit"
                               cssClass="mdl-cell mdl-cell--12-col">
                        <h1>${title}</h1>
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
                                <label class="mdl-textfield__label" for="height">Estatura (M)</label>
                                <form:label path="height" cssClass="">
                                    <form:errors path="height" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- width -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input path="width" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="width">Peso (Kg)</label>
                                <form:label path="width" cssClass="">
                                    <form:errors path="width" cssClass=""/>
                                </form:label>
                            </div>


                            <!-- email -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                                <form:input
                                        path="email"
                                        type="text"
                                        cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label"
                                       for="email">Email</label>
                                <form:label
                                        path="email"
                                        cssClass="">
                                    <form:errors
                                            path="email"
                                            cssClass=""/>
                                </form:label>
                            </div>

                            <input type="submit"
                                   value="Registrarse"
                                   class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"
                                   style="width: 30%; margin-bottom: 5%; margin-top: 10%;">

                        </div>
                    </form:form>
                </div>
            </c:otherwise>
        </c:choose>
        <div style="height: 5%; width: 5%;"></div>
    </jsp:body>
</template:main>
