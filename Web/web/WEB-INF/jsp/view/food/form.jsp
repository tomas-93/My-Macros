<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<template:app htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <form:form action="${url}" method="post" modelAttribute="foodDto"
                   cssClass="mdl-cell mdl-cell--12-col" cssStyle="">
            <h1>Alimento</h1>
            <form:hidden path="macronutrientsDto.id" value="${foodDto.macronutrientsDto.id}"/>
            <form:hidden path="userDto.id" value="${foodDto.userDto.id}"/>
            <form:hidden path="id" value="${foodDto.id}"/>
            <label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" for="switch">
                <span  class="mdl-switch__label">Registro complejo?</span>
                <input onclick="sw()"  type="checkbox" id="switch" class="mdl-switch__input" >
                <input value="on" type="hidden" id="switch1">

            </label>

            <!-- Nombre Alimento -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="name" type="text" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label" for="name">Nombre del Alimento</label>
                <form:label path="name" cssClass="">
                    <form:errors path="name" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre brand -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="brand" type="text" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label" for="brand">Nombre Marca</label>
                <form:label path="brand" cssClass="">
                    <form:errors path="brand" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre unit -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="unit" type="text" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label" for="unit">Unidad (ejemplo: g, ml, pieza, etc...)</label>
                <form:label path="unit" cssClass="">
                    <form:errors path="unit" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre quantity -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="quantity" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label" for="quantity">Cantidad</label>
                <form:label path="quantity" cssClass="">
                    <form:errors path="quantity" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre totalCarbohydrates -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="macronutrientsDto.totalCarbohydrates" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.totalCarbohydrates">Carbohidratos</label>
                <form:label path="macronutrientsDto.totalCarbohydrates" cssClass="">
                    <form:errors path="macronutrientsDto.totalCarbohydrates" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre fiber -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="macronutrientsDto.fiber" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.fiber">Fibra</label>
                <form:label path="macronutrientsDto.fiber" cssClass="">
                    <form:errors path="macronutrientsDto.fiber" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre sugar -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput x">
                <form:input path="macronutrientsDto.sugar" type="number" cssClass="mdl-textfield__input sugar"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.sugar">Azucar</label>
                <form:label path="macronutrientsDto.sugar" cssClass="">
                    <form:errors path="macronutrientsDto.sugar" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre totalProtein -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="macronutrientsDto.totalProtein" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.totalProtein">Proteina</label>
                <form:label path="macronutrientsDto.totalProtein" cssClass="">
                    <form:errors path="macronutrientsDto.totalProtein" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre totalFats -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="macronutrientsDto.totalFats" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.totalFats">Grasas</label>
                <form:label path="macronutrientsDto.totalFats" cssClass="">
                    <form:errors path="macronutrientsDto.totalFats" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre saturated -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput x">
                <form:input path="macronutrientsDto.saturated" type="number" cssClass="mdl-textfield__input saturated"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.saturated">Grasas Saturadas</label>
                <form:label path="macronutrientsDto.saturated" cssClass="">
                    <form:errors path="macronutrientsDto.saturated" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre monounsaturated -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput x">
                <form:input path="macronutrientsDto.monounsaturated" type="number" cssClass="mdl-textfield__input monounsaturated"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.monounsaturated">Grasas Monoinsaturadas</label>
                <form:label path="macronutrientsDto.monounsaturated" cssClass="">
                    <form:errors path="macronutrientsDto.monounsaturated" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre polyunsaturated -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput x">
                <form:input path="macronutrientsDto.polyunsaturated" type="number" cssClass="mdl-textfield__input polyunsaturated"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.polyunsaturated">Grasas Poliinsaturadas</label>
                <form:label path="macronutrientsDto.polyunsaturated" cssClass="">
                    <form:errors path="macronutrientsDto.polyunsaturated" cssClass=""/>
                </form:label>
            </div>
            <!-- Nombre totalCal -->
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label componetsInput">
                <form:input path="macronutrientsDto.totalCal" type="number" cssClass="mdl-textfield__input"/>
                <label class="mdl-textfield__label"
                       for="macronutrientsDto.totalCal">Total de Calorias
                </label>
                <form:label path="macronutrientsDto.totalCal" cssClass="">
                    <form:errors path="macronutrientsDto.totalCal" cssClass=""/>
                </form:label>
            </div>
            <br>
            <input type="submit"
                   value="Enviar"
                   class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect"
                   style="width: 30%; margin-left: 5%; margin-bottom: 5%; margin-top: 5%;">
        </form:form>
    </jsp:body>
</template:app>
