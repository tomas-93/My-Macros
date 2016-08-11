<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:app htmlTitle="${foodDto.name}" bodyTitle="${foodDto.name}">
    <jsp:body>
        <div class="mdl-grid">
            <div class="mdl-cell mdl-cell--12-col mdl-card mdl-shadow--2dp"
                 style="float: left; margin: 2% 4% 2% 4%; width: 100%;">
                <div class="mdl-card__title mdl-card--border">
                    <h2>
                            ${foodDto.name}
                    </h2>
                    <a id ="edit" href="/app/food/edit/${foodDto.id}"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">edit</i>
                    </a>
                    <div class="mdl-tooltip mdl-tooltip--large" for="edit" style="height: 3%;">
                        Editar
                    </div>
                    <a id="remove" href="/app/food/remove/${foodDto.id}"
                       class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                        <i class="material-icons">delete</i>
                    </a>
                    <div class="mdl-tooltip mdl-tooltip--large" for="remove" style="height: 3%;">
                        Eliminar
                    </div>
                    <h2 style="position:absolute; right: 10%;">
                        Cl: ${foodDto.macronutrientsDto.totalCal}
                    </h2>
                </div>
                <div class="mdl-card__supporting-text mdl-card--border">
                    <div class="macrosLabel">
                        <label class="font-name">Carbs:</label>
                        <label class="split"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.totalCarbohydrates}
                        </label>
                    </div>
                    <div class="macrosLabel">
                        <label class="child">Azucar:</label>
                        <label class="split-child"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.sugar}
                        </label><br>
                    </div>
                    <div class="macrosLabel">
                        <label class="child">Fiber:</label>
                        <label class="split-child"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.fiber}
                        </label>
                    </div>
                    <div class="macrosLabel">
                        <label class="font-name">Proteina:</label>
                        <label class="split"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.totalProtein}
                        </label><br>
                    </div>
                    <div class="macrosLabel">
                        <label class="font-name">Grasa:</label>
                        <label class="split"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.totalFats}
                        </label><br>
                    </div>
                    <div class="macrosLabel">
                        <label class="child">Saturadas:</label>
                        <label class="split-child"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.saturated}
                        </label><br>
                    </div>
                    <div class="macrosLabel">
                        <label class="child">Monoinsaturadas:</label>
                        <label class="split-child"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.monounsaturated}
                        </label><br>
                    </div>
                    <div class="macrosLabel">
                        <label class="child">Poliinsaturadas:</label>
                        <label class="split-child"></label>
                        <label class="font-number">
                                ${foodDto.macronutrientsDto.polyunsaturated}
                        </label><br>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</template:app>