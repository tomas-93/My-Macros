<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:app bodyTitle="Lista de alimentos" htmlTitle="Lista de alimentos">
    <jsp:body>
        <c:forEach items="${foodDtoList}" var="foodDto">
            <div class="mdl-card mdl-shadow--2dp" style="float: left; margin: 2% 4% 2% 4%;">
                <div class="mdl-card__title mdl-card--border">
                    <h2 class="mdl-card__title-text">
                            ${foodDto.name}
                    </h2>
                </div>
                <div class="mdl-card__supporting-text mdl-card--border">
                    <div class="macrosLabel">
                        <label class="etiqueta">Carbs:</label>
                        <div class="split" style="margin-top: 4%;width: 60%;margin-left: 5%;"></div>
                        <label class="font">
                                ${foodDto.macronutrientsDto.totalCarbohydrates}
                        </label>
                    </div>

                    <div class="macrosLabel">
                        <label class="etiqueta">Fiber:</label>
                        <div class="split" style="margin-top: 4%;width: 60%;margin-left: 5%;"></div>
                        <label class="font">
                                ${foodDto.macronutrientsDto.fiber}
                        </label>
                    </div>

                    <div class="macrosLabel">
                        <label class="etiqueta" >Proteina:</label>
                        <div class="split" style="margin-top: 4%;width: 60%;margin-left: 5%;"></div>
                        <label class="font">
                                ${foodDto.macronutrientsDto.totalProtein}
                        </label>
                    </div>

                    <div class="macrosLabel">
                        <label class="etiqueta">Grasa:</label>
                        <div class="split" style="margin-top: 4%;width: 60%;margin-left: 5%;"></div>
                        <label class="font">
                                ${foodDto.macronutrientsDto.totalFats}
                        </label>
                    </div>

                    <div class="macrosLabel">
                        <label class="etiqueta">Calorias:</label>
                        <div class="split" style="margin-top: 4%;width: 60%;margin-left: 5%;"></div>
                        <label class="font">
                                ${foodDto.macronutrientsDto.totalCal}
                        </label>
                    </div>

                </div>
                <div class="mdl-card__actions mdl-card--border">
                    <a href="/app/food/edit/${foodDto.id}"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">edit</i>
                    </a>

                    <a href="/app/food/remove/${foodDto.id}"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">delete</i>
                    </a>

                    <a href="/app/food/view/${foodDto.id}"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">pageview</i>
                    </a>
                </div>
            </div>
        </c:forEach>
        <a href="/app/food/add" style="float: right; position: fixed; bottom: 5%; right: 5%;"
           class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect mdl-button--accent">
            <i class="material-icons">add</i>
        </a>
    </jsp:body>
</template:app>