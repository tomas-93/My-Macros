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
        <div class="row" style="margin: 0; padding: 0;">
            <div id="nav" class="col s2 m2 l1" style="margin: 0; padding: 0;">
                <div id="icon" class="row s2 m2 l1 blue" style="margin: 0; padding: 0;">Icono</div>
                <div id="menu" class="row s2 m2 l1 red" style="margin: 0; padding: 0;">Menu</div>
            </div>
            <div id="app" class="col s10 m10 l11" style="margin: 0; padding: 0;">
                <div id="title" class="row s10 m10 l11 red" style="margin: 0; padding: 0;"><c:out value="${bodyTitle}"/></div>
                <div id="appC" class="row s10 m10 l11 blue" style="margin: 0; padding: 0;"><jsp:doBody /></div>
            </div>
        </div>
         <!-- Compiled and minified JavaScript -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.6/js/materialize.min.js"></script>
    </body>
</html>
