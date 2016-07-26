<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <title><c:out value="${htmlTitle}"/></title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
        <link rel="stylesheet" href="/resource/css/material.min.css">
        <link rel="stylesheet" href="/resource/css/app.css">

    </head>
    <body>
    <!-- No header, and the drawer stays open on larger screens (fixed drawer). -->
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header ">
        <header class="mdl-layout__header">
            <div class="mdl-layout__header-row">
                <!-- Title -->
                <h1 class="mdl-layout-title"><c:out value="${bodyTitle}"/></h1>
            </div>
        </header>
        <div class="mdl-layout__drawer">
            <span class="mdl-layout-title">My-Macros</span>
            <nav class="mdl-navigation">
                <a class="mdl-navigation__link" href="/daily/list/${userDto.id}">Diario</a>
                <a class="mdl-navigation__link" href="/food/list/${userDto.id}">Alimentos</a>
                <a class="mdl-navigation__link" href="/recipe/list/${userDto.id}">Receta</a>
                <a class="mdl-navigation__link" href="/profile/view/${userDto.id}">Perfil</a>
                <a class="mdl-navigation__link" href="/user/view/${userDto.id}">Usurio</a>
            </nav>
        </div>
        <main class="mdl-layout__content">
            <div class="page-content">
                <div><jsp:doBody /></div>
            </div>
        </main>
    </div>
         <!-- Compiled and minified JavaScript --->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>

    </body>
</html>
