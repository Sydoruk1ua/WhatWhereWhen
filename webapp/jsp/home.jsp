<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<body>
<%--HEADER--%>
<jsp:include page="common/header.jsp"/>
<fmt:message key="welcome.user"/>
Home
<a href="controller">Main Controller</a>
<form action="users" method="POST">
    <input type="submit" value="Users">
</form>
<form action="login" method="POST">
    <input type="submit" value="Sign in">
</form>

<form action="registration" method="POST">
    <input type="submit" value="Sign up">
</form>

<%--FOOTER--%>
<jsp:include page="common/footer.jsp"/>
</body>
</html>