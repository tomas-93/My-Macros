<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 26/07/2016
  Time: 06:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
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
    <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.light_blue-pink.min.css" />
    <link rel="stylesheet" href="/resource/css/app.css">
    <!-- Compiled and minified JavaScript --->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script defer src="https://code.getmdl.io/1.1.3/material.min.js"></script>
    <script type="text/javascript" src="/resource/js/app.js"></script>
</head>
<body>
<div><jsp:doBody /></div>

</body>
</html>
