<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<fmt:setLocale value="ru_RU" scope="session"/>
<fmt:setBundle basename="i18n"/>
<html>
<head>
    <title>Home</title>
</head>
<body>
<fmt:message key="test.locale"/>
Home
<form action="login" method="POST">
    <input type="submit" value="Login">
</form>
<form action="users" method="POST">
    <input type="submit" value="Users">
</form>

<%--FOOTER--%>
<c:import url="common/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>