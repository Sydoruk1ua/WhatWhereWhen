<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h2>Users</h2>
    <!--Search Form -->
    <form action="/users" method="get" id="searchUserForm" role="form">
        <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
        <div class="form-group col-xs-5">
            <input type="text" name="userName" id="userName" class="form-control" required="true"
                   placeholder="Type the Name or Last Name of the user"/>
        </div>
        <button type="submit" class="btn btn-info">
            <span class="glyphicon glyphicon-search"></span> Search
        </button>
        <br></br>
        <br></br>
    </form>
    <!--Users List-->
    <form action="/users" method="post" id="userForm" role="form">
        <c:choose>
            <c:when test="${not empty usersList}">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>#</td>
                        <td>email</td>
                        <td>First name</td>
                        <td>Last name</td>
                        <td>Role</td>
                    </tr>
                    </thead>
                    <c:forEach var="user" items="${usersList}">
                        <c:set var="classSuccess" value=""/>
                        <c:if test="${idUser == user.id}">
                            <c:set var="classSuccess" value="info"/>
                        </c:if>
                        <tr class="${classSuccess}">
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.role.type}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    No people found matching your search criteria
                </div>
            </c:otherwise>
        </c:choose>
    </form>
</div>
</body>
</html>
