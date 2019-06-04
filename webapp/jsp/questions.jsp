<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"  value="${not empty sessionScope.lang ? sessionScope.lang : 'en' }"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n"/>
<html>
<head>
    <title>Questions</title>
</head>
<body>

<jsp:include page="common/header.jsp"/>
<div class="container">
    <h2><fmt:message key="questions"/></h2>
    <!--Questions List-->
    <form action="app" method="post" role="form">
        <input type="hidden" name="command" value="questions"/>

        <c:choose>
            <c:when test="${not empty questionsList}">

                <table class="table table-striped">
                    <tr>
                        <td>#</td>
                        <td>Question</td>
                    </tr>
                    </thead>
                    <c:if test="${language == 'en'}">
                        <c:forEach var="question" items="${questionsList}">
                            <tr>
                                <td>${question.id}</td>
                                <td>${question.questionEn}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${language == 'ru'}">
                        <c:forEach var="question" items="${questionsList}">
                            <tr>
                                <td>${question.id}</td>
                                <td>${question.questionRu}</td>
                            </tr>
                        </c:forEach>
                    </c:if>

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
