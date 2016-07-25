<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/jsp/base.jspf"%>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/css/materialize.min.css">
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link rel="stylesheet" href="/resource/css/app.css">
</head>
<body>
    <div id="conteinerLogin" class="card row center">
        <h3>Login</h3>
        <form:form modelAttribute="userDto" method="post" action="/user/session" cssClass="col s12 m12 l12">
            <form:input path="userName" type="text" placeholder="Nombre de Usurio o Email" cssClass="col s12 m12 l12"/>
            <form:label path="" cssClass="col s12 m12 l12 red-text accent-4 flow-text">
                <form:errors path="userName" cssClass="col s12 m12 l12">Usurio o Email incorrecto</form:errors>
            </form:label>
            <form:input path="password" type="password" placeholder="Password" cssClass="col s12 m12 l12"/>
            <form:label path="" cssClass="col s12 m12 l12 red-text accent-4 flow-text">
                <form:errors path="password" cssClass="col s12 m12 l12">Password Incorrecto</form:errors>
            </form:label>
            <input type="submit" value="Login" class="col s4 m4 l4 waves-effect btn">
            <a href="<c:url value=""/> " class="col s1 m1 l1">Registrarce?</a>
        </form:form>
    </div>
    <!-- Compiled and minified JavaScript -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
</body>
</html>
