<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<link rel="stylesheet" href="<c:url value="/css1/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<html>
<head>
    <title>Login</title>
</head>
<body>
<%--HEADER--%>
<jsp:include page="common/header.jsp"/>
<div id="login">
    <h3 class="text-center text-white pt-5">Login form</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="controller" method="post">
                        <input type="hidden" name="command" value="login"/>
                        <h3 class="text-center text-info">Sign In</h3>
                        <div class="form-group">
                            <label for="email" class="text-info">Email:</label><br>
                            <input type="text" name="email" id="email" class="form-control" required>
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
<jsp:include page="common/footer.jsp"/>
</body>
</html>
