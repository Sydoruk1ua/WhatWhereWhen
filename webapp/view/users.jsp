<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <script src="../js/bootstrap.min.js"></script>
</head>

<body>
text
<div class="container">
    <h2>Users</h2>
    <!--Users List-->
    <form action="/users" method="post" id="userForm" role="form">
        <table class="table table-striped">
            <thead>
            <tr>
                <td>#</td>
                <td>email</td>
                <td>First name</td>
                <td>Last date</td>
                <td>Role</td>
            </tr>
            </thead>
        </table>
    </form>
</div>
</body>
</html>
