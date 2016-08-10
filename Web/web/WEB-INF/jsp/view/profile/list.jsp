<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:app htmlTitle="Lista de Perfiles" bodyTitle="Lista de Perfiles">
    <jsp:body>
        <div class="mdl-grid">


            <c:forEach items="${listProfile}" var="profile">
                <div class="mdl-cell mdl-cell--5-col mdl-cell--10-col-tablet mdl-cell--10-col-phone">
                    <div class="mdl-card mdl-shadow--2dp" style=" width: 100%;">
                        <div class="mdl-card__title mdl-card--border">
                            <h2 class="mdl-card__title-text">
                                <c:out value="${profile.name}"/>
                            </h2>
                        </div>
                        <div class="mdl-card__supporting-text mdl-card--border">
                            <div class="macrosLabel">
                                <label class="etiqueta">Carbs:</label>
                                <div class="split" style="margin-top: 4%;"></div>
                                <label class="font">
                                        ${profile.macronutrientsDto.totalCarbohydrates}
                                </label>
                            </div>

                            <div class="macrosLabel">
                                <label class="etiqueta">Fiber:</label>
                                <div class="split" style="margin-top: 4%;"></div>
                                <label class="font">
                                        ${profile.macronutrientsDto.fiber}
                                </label>
                            </div>

                            <div class="macrosLabel">
                                <label class="etiqueta">Proteina:</label>
                                <div class="split" style="margin-top: 4%;"></div>
                                <label class="font">
                                        ${profile.macronutrientsDto.totalProtein}
                                </label>
                            </div>

                            <div class="macrosLabel">
                                <label class="etiqueta">Grasa:</label>
                                <div class="split" style="margin-top: 4%;"></div>
                                <label class="font">
                                        ${profile.macronutrientsDto.totalFats}
                                </label>
                            </div>

                            <div class="macrosLabel">
                                <label class="etiqueta">Calorias:</label>
                                <div class="split" style="margin-top: 4%;"></div>
                                <label class="font">
                                        ${profile.macronutrientsDto.totalCal}
                                </label>
                            </div>
                        </div>
                        <div class="mdl-card__actions mdl-card--border">
                            <a href="/app/profile/edit/${profile.id}"
                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                Edit <i class="material-icons">edit</i>
                            </a>
                            <a href="/app/profile/remove/${profile.id}"
                               class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                Eliminar <i class="material-icons">delete</i>
                            </a>
                        </div>
                    </div>

                </div>

            </c:forEach>
        </div>
        <a href="/app/profile/add" style="float: right; position: fixed; bottom: 5%; right: 3%;"
           class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--accent">
            <i class="material-icons">add</i>
        </a>
    </jsp:body>
</template:app>
