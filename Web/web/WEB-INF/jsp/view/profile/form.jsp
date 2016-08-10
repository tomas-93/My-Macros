<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:app htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <div class="mdl-grid--no-spacing">
            <form:form action="${url}" method="post" modelAttribute="profileDto"
                       cssClass="mdl-cell mdl-cell--12-col" cssStyle="padding: 5%;">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 80%">
                    <form:input path="name" type="text" cssClass="mdl-textfield__input"/>
                    <label class="mdl-textfield__label" for="name">Nombre del Perfil</label>
                    <form:label path="name" cssClass="">
                        <form:errors path="name" cssClass=""/>
                    </form:label>
                </div>
                <form:hidden path="id" value="${profileDto.id}"/>
                <form:hidden path="macronutrientsDto.id" value="${profileDto.macronutrientsDto.id}"/>
                <p>
                    <label for="macronutrientsDto.totalCarbohydrates">Carbohidratos</label>
                    <input id="rageCarb" class="mdl-slider mdl-js-slider"
                                type="range" min="0" max="500" value="250"
                           step="1" onmousemove="rage(id)" title="Carbohidratos"/>
                    <form:input path="macronutrientsDto.totalCarbohydrates"
                                class="mdl-textfield__input totalCarbohydrates"
                                type="text"/>
                    <form:label path="macronutrientsDto.totalCarbohydrates" cssClass="">
                        <form:errors path="macronutrientsDto.totalCarbohydrates" cssClass=""/>
                    </form:label>

                </p>
                <p>
                    <label for="macronutrientsDto.fiber">Fibra</label>
                    <input id="rageFiber" class="mdl-slider mdl-js-slider"
                                type="range" min="0" max="500" value="250" step="1"
                           title="Fibra" onmousemove="rage(id)"/>
                    <form:input path="macronutrientsDto.fiber" class="mdl-textfield__input fiber"
                                type="text" />
                    <form:label path="macronutrientsDto.fiber" cssClass="">
                        <form:errors path="macronutrientsDto.fiber" cssClass=""/>
                    </form:label>
                </p>
                <p>
                    <label for="macronutrientsDto.totalProtein">Proteina</label>
                    <input id="rageProte" class="mdl-slider mdl-js-slider"
                           type="range" min="0" max="500" value="250" step="1"
                           title="Proteina" onmousemove="rage(id)"/>
                    <form:input path="macronutrientsDto.totalProtein"
                                class="mdl-textfield__input totalProtein"
                                type="text"/>
                    <form:label path="macronutrientsDto.totalProtein" cssClass="">
                        <form:errors path="macronutrientsDto.totalProtein" cssClass=""/>
                    </form:label>

                </p>
                <p>
                    <label for="macronutrientsDto.totalFats">Grasas</label>
                    <input id="rageFat" class="mdl-slider mdl-js-slider"
                           type="range" min="0" max="500" value="250" step="1" title="Gragas"
                           onmousemove="rage(id)"/>
                    <form:input path="macronutrientsDto.totalFats"
                                class="mdl-textfield__input totalFats"
                                type="text"/>
                    <form:label path="macronutrientsDto.totalFats" cssClass="">
                        <form:errors path="macronutrientsDto.totalFats" cssClass=""/>
                    </form:label>
                </p>
                <p>
                    <label for="macronutrientsDto.totalCal">Total de Calorias</label>
                    <input id="rageCal" class="mdl-slider mdl-js-slider"
                           type="range" min="0" max="3000" value="250" step="1"
                           title="Total de Calorias" onmousemove="rage(id)"/>
                    <form:input path="macronutrientsDto.totalCal"
                                class="mdl-textfield__input totalCal"
                                type="text" />
                    <form:label path="macronutrientsDto.totalCal" cssClass="">
                        <form:errors path="macronutrientsDto.totalCal" cssClass=""/>
                    </form:label>
                </p>
                <input type="submit"
                       value="Enviar"
                       class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"
                       style="width: 30%; margin-bottom: 5%; margin-top: 5%;">
            </form:form>
        </div>
    </jsp:body>
</template:app>