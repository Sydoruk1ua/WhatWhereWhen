<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%--<div class="wrapper">
    <jsp:include page="common/header.jsp"/>
    <section>
        <div class="row justify-content-center">

            <form action="<c:url value="/login"/>" class="form-group col-md-4">
                <h1 class="text-center"><fmt:message key="login" /></h1>
                <h6 class="text-danger">${sessionScope.login_error}</h6>
                <c:remove var="login_error" scope="session"/>
                <input placeholder="<fmt:message key="username" />" name="username" class="input-group">
                <input type="password" placeholder="<fmt:message key="password" />" name="password" class="input-group">
                <a href="<c:url value="/home"/>" class="input-group">
                    <fmt:message key="create.account" /></a>
                <button class="btn btn-success"><fmt:message key="to.login"/></button>
            </form>
        </div>
    </section>
</div>--%>
<jsp:include page="common/header.jsp"/>
<div id="login">
    <h3 class="text-center text-white pt-5">Login form</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="" method="post">
                        <h3 class="text-center text-info">Sign In</h3>
                        <div class="form-group">
                            <label for="username" class="text-info">Email:</label><br>
                            <input type="text" name="username" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="text" name="password" id="password" class="form-control" required>
                        </div>
                        <div id="login-link" class="text-left">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="Sign In">
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

<%--FOOTER--%>
<c:import url="common/footer.jsp" charEncoding="UTF-8"/>
</body>
</html>
