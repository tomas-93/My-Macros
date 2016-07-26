<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 25/07/2016
  Time: 08:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="title" value="Vista de Usuario"/>
<template:main htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <div class="mdl-card mdl-shadow--4dp" style="width: 50%; margin: 1% auto;">
            <div class="mdl-card__title">
                <h3>Nombre: ${userDto.name} ${userDto.surname}</h3>
            </div>
            <!--div class="mdl-card__media">
                ...
            </div-->
            <div class="mdl-card--border">

            </div>
            <div class="mdl-card__supporting-text">
                <h3>Altura: ${userDto.height}</h3>
                <h3>Peso: ${userDto.width}</h3>
                <h3>Email: ${userDto.email}</h3>
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <a style="float: right" class="mdl-button mdl-js-button mdl-button--fab mdl-js-ripple-effect"
                        href="<c:url value="/user/edit/${userDto.id}"/> ">
                    <i class="material-icons">edit</i>
                </a>
                <h3 style="float: right; margin: 1% 3% 0 3%;">Edit</h3>

            </div>
        </div>
    </jsp:body>
</template:main>
