<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Users</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="../css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="../css/style.css" rel="stylesheet">
    <!-- MDBootstrap Datatables  -->
    <link href="../css/addons/datatables.min.css" rel="stylesheet">
</head>
<body>
<%--HEADER--%>
<jsp:include page="common/header.jsp"/>
<div class="container">
    <h2>Users</h2>

    <c:choose>
    <c:when test="${not empty usersList}">
    <table id="userTable" class="table table-striped table-bordered table-sm table-dark">
            <%--class="table table-striped"--%>
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
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.role.type}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</c:when>
<c:otherwise>
    <br>
    <div class="alert alert-info">
        No people found matching your search criteria
    </div>
</c:otherwise>
</c:choose>

</div>
<%--FOOTER--%>
<jsp:include page="common/footer.jsp"/>
<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="../js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="../js/mdb.min.js"></script>
<!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="../js/addons/datatables.min.js"></script>
<script>
    $(document).ready(function () {
        $('#userTable').DataTable();
        $('.dataTables_length').addClass('bs-select');
    });
</script>
</body>
</html>