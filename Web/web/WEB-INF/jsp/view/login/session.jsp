<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 24/07/2016
  Time: 08:04 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="title" value="My-Macros"/>
<template:login htmlTitle="${title}" bodyTitle="${title}">
    <jsp:body>
        <div class="mdl-grid--no-spacing" style="padding: 0px; margin: auto 0px auto 0px;">
            <div class="mdl-cell mdl-cell--12-col" style="padding: 0px; margin: 0px;">
                <div id="conteinerLogin">
                    <h3>Login</h3>
                    <form:form modelAttribute="loginDto" method="post" action="/login/session"
                               cssClass="col s12 m12 l12">
                        <div class="mdl-cell mdl-cell--12-col">
                            <!--
                                User
                                -->
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="weight: 100%">
                                <form:input path="email" type="text" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="email">Email</label>
                                <form:label path="email" cssClass="">
                                    <form:errors path="email"
                                                 cssClass=""/>
                                </form:label>
                            </div>
                        </div>
                        <!--
                        password
                        -->

                        <div class="mdl-cell mdl-cell--12-col" >
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label" style="weight: 100%">
                                <form:input path="password" type="password" cssClass="mdl-textfield__input"/>
                                <label class="mdl-textfield__label" for="password">Password</label>
                                <form:label path="password" cssClass="">
                                    <form:errors path="password"
                                                 cssClass=""/>
                                </form:label>
                            </div>
                        </div>
                        <input type="submit" value="Login"
                               class="mdl-button mdl-js-button mdl-button--raised" style="weight: 50%;">
                        <a href="<c:url value="/login/add"/> " style="margin-top: 1%;">Registrarce?</a>
                    </form:form>
                </div>
            </div>
        </div>
    </jsp:body>
</template:login>
