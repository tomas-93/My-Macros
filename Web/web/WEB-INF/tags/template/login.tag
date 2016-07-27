<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 26/07/2016
  Time: 05:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ include file="/WEB-INF/jsp/base.jspf" %>
<template:my-macros htmlTitle="${htmlTitle}" bodyTitle="${htmlTitle}">
    <jsp:body>
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
                    <a class="mdl-navigation__link" href="/help">Acerca De...</a>
                    <a class="mdl-navigation__link" href="/login/form">Login</a>
                    <a class="mdl-navigation__link" href="/login/add">Registrarse</a>
                </nav>
            </div>
            <main class="mdl-layout__content">
                <div class="page-content">
                    <div><jsp:doBody /></div>
                </div>
            </main>
        </div>
    </jsp:body>
</template:my-macros>