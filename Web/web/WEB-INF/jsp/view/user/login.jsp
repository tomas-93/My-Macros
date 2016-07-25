<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/jsp/base.jspf" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
    <link rel="stylesheet" href="/resource/css/material.min.css">
    <link rel="stylesheet" href="/resource/css/app.css">
</head>
<body>
<div class="mdl-grid--no-spacing" style="padding: 0px; margin: auto 0px auto 0px;">
    <div class="mdl-cell mdl-cell--12-col" style="padding: 0px; margin: 0px;">
        <div id="conteinerLogin">
            <h3>Login</h3>
            <form:form modelAttribute="loginDto" method="post" action="/user/session"
                       cssClass="col s12 m12 l12">
                <div class="mdl-cell mdl-cell--12-col">
                    <!--
                        User
                        -->
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%">
                        <form:input path="userName" type="text" cssClass="mdl-textfield__input"/>
                        <label class="mdl-textfield__label" for="userName">Email</label>
                        <form:label path="userName" cssClass="">
                            <form:errors path="userName"
                                         cssClass=""/>
                        </form:label>
                    </div>
                </div>
                <!--
                password
                -->

                <div class="mdl-cell mdl-cell--12-col" >
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="width: 100%">
                        <form:input path="password" type="password" cssClass="mdl-textfield__input"/>
                        <label class="mdl-textfield__label" for="password">Password</label>
                        <form:label path="password" cssClass="">
                            <form:errors path="password"
                                         cssClass=""/>
                        </form:label>
                    </div>
                </div>
                <input type="submit" value="Login"
                       class="mdl-button mdl-js-button mdl-button--raised" style="width: 50%;">
                <a href="<c:url value="/user/add"/> " style="margin-top: 1%;">Registrarce?</a>
            </form:form>
        </div>
    </div>
</div>


<!-- Compiled and minified JavaScript -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
</body>
</html>
