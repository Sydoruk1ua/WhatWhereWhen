<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Main</title>
</head>
<body>
<%--HADER--%>
<jsp:include page="common/header.jsp"/>
<fmt:message key="welcome.user"/> Home
<%--<a href="controller">Main Controller</a>--%>
<form action="users" method="POST">
    <input type="submit" value="Users">
</form>
<a href="app">Return to login page</a>
<form action="app">
    <input type="hidden" name="command" value="login_page"/>
    <input type="submit" value="Sign in">
</form>

<form action="registration" method="POST">
    <input type="submit" value="Sign up">
</form>

<form action="app" method="POST">
    <input type="hidden" name="command" value="questions"/>
    <input type="submit" value="Questions">
</form>


<%--FOOTER--%>
<footer class="py-0 bg-dark fixed-bottom">
    <!-- Copyright -->
    <div class="text-center py-3 text-white-50">© 2019 Copyright:
        <a href="https://github.com/Sydoruk1ua/WhatWhereWhen"> Sydoruk1ua</a>
    </div>
    <!-- Copyright -->
</footer>
</body>
</html>
