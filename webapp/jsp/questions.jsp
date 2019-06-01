<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<body>
<jsp:include page="common/header.jsp"/>
<div class="container">
    <h2>Questions</h2>
    <%--    <!--Search Form -->
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
        </form>--%>
    <!--Users List-->
    <form action="/controller" method="post" role="form">
        <input type="hidden" name="command" value="questions"/>
        <c:choose>
            <c:when test="${not empty questionsList}">

                <table class="table table-striped">
                    <tr>
                        <td>#</td>
                        <td>Question</td>
                    </tr>
                    </thead>
                    <c:forEach var="question" items="${questionsList}">
                        <%--   <c:set var="classSuccess" value=""/>
                           <c:if test="${idUser == user.id}">
                               <c:set var="classSuccess" value="info"/>
                           </c:if>--%>
                        <tr>
                            <td>${question.id}</td>
                            <td>${question.questionEn}</td>
                        </tr>
                    </c:forEach>
                    <thead>
                </table>
            </c:when>
            <c:otherwise>
                <br>
                <div class="alert alert-info">
                    No questions found matching your search criteria
                </div>
            </c:otherwise>
        </c:choose>
    </form>
</div>
<%--FOOTER--%>
<jsp:include page="common/footer.jsp"/>
</body>
</html>
