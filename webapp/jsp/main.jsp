<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>Main</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/mdb.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/addons/datatables.min.css" rel="stylesheet">
</head>
<body>
<%--HADER--%>
<jsp:include page="common/header.jsp"/>
<fmt:message key="welcome.user"/> Home

<form action="app" method="POST">
    <input type="hidden" name="command" value="users"/>
    <input type="submit" value="Users">
</form>
<a href="app">Return to login page</a>
<form action="app">
    <input type="hidden" name="command" value="login_page"/>
    <input type="submit" value="Sign in">
</form>

<form action="app">
    <input type="hidden" name="command" value="registration_page"/>
    <input type="submit" value="Sign up">
</form>

<form action="app" method="POST">
    <input type="hidden" name="command" value="questions"/>
    <input type="submit" value="Questions">
</form>
<form action="app">
    <input type="hidden" name="command" value="add_question"/>
    <input type="submit" value="Add question">
</form>
<%--FOOTER--%>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
