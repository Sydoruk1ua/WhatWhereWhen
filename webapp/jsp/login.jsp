<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Sign in</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/mdb.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/addons/datatables.min.css" rel="stylesheet">
</head>
<body>
<%--HEADER--%>
<jsp:include page="common/header.jsp"/>
<div id="login">
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="app" method="post">
                        <input type="hidden" name="command" value="login"/>
                        <h3 class="text-center text-info"><fmt:message key="signin"/></h3>
                        <div class="form-group">
                            <label for="email"> <fmt:message key="email"/>:</label><br>
                            <input id="email" type="email" name="email"
                                   placeholder="<fmt:message key="email.placeholder"/>" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password"><fmt:message key="password"/>:</label><br>
                            <input type="password" name="password" id="password"
                                   placeholder="<fmt:message key="password.placeholder"/>" class="form-control" required
                                   pattern="^(?=.*?[A-ZА-Я])(?=.*?[a-zа-я])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,45}$"
                                   title="<fmt:message key="password.verification.message"/>">
                        </div>
                        <div id="login-link" class="text-left">
                            <input type="submit" name="submit" class="btn btn-info btn-md"
                                   value="<fmt:message key="signin.enter"/>">
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>
<object data="../img/whatwherewhen.mp3">
    <param name="autoplay" value="true">
</object>
<%--FOOTER--%>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
