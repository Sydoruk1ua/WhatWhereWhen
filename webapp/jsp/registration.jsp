<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
<link rel="stylesheet" href="<c:url value="/css/style.css"/>"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
<html>
<jsp:include page="common/header.jsp"/>
<div id="register">
    <h3 class="text-center text-white pt-5">Login form</h3>
    <div class="container">
        <div id="register-row" class="row justify-content-center align-items-center">
            <div id="register-column" class="col-md-6">
                <div id="register-box" class="col-md-12">
                    <form id="register-form" class="form" action="" method="post">
                        <h3 class="text-center text-info">Register</h3>
                        <div class="form-group">
                            <label for="first_name" class="text-info">First Name:</label><br>
                            <input type="text" name="first_name" id="first_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="last_name" class="text-info">Last Name:</label><br>
                            <input type="text" name="last_name" id="last_name" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="username" class="text-info">Email:</label><br>
                            <input type="text" name="username" id="username" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-info">Password:</label><br>
                            <input type="text" name="password" id="password" class="form-control" required>
                        </div>
                        <div class="form-group">
                            <label for="password_repeat" class="text-info">Confirm Password:</label><br>
                            <input type="text" name="password_repeat" id="password_repeat" class="form-control"
                                   required>
                        </div>

                        <input type="submit" name="submit" class="btn btn-info btn-md" value="Sign up">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


</html>
