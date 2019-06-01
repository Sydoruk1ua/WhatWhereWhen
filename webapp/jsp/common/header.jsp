<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>"/>
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<c:set var="language" value="${not empty sessionScope.lang ? sessionScope.lang : 'en' }" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="i18n" scope="session"/>

<header>
    <div class="container-fluid">
        <div class="row">
            <nav class="navbar bg-dark navbar-expand-md navbar-light col justify-content-between">
                <form action="app" class="text-light navbar-brand">
                    <input type="hidden" name="command" value="main_page"/>
                    <input type="submit" class="btn btn-info btn-md" value=<fmt:message key="home"/>>
                </form>


                <c:if test="${not empty sessionScope.user}">
                    <h6 class="nav-item text-light"><fmt:message key="welcome.user"/>
                            ${sessionScope.user}</h6>
                </c:if>
                <div class="navbar-nav">
                    <c:if test="${empty sessionScope.user}">
                        <form action="app" class="text-light navbar-brand">
                            <input type="hidden" name="command" value="login_page"/>
                            <input type="submit" class="btn btn-info btn-md" value=<fmt:message key="login"/>>
                        </form>
                    </c:if>


                    <c:if test="${not empty sessionScope.user}">
                        <form action="app" class="text-light navbar-brand">
                            <input type="hidden" name="command" value="logout"/>
                            <input type="submit" class="btn btn-info btn-md" value=<fmt:message key="logout"/>>
                        </form>
                    </c:if>
                    <%-- <c:if test="${sessionScope.user.role.get() == 'CLIENT'}">
                         <a href="<c:url value="/app/client/newReportPage"/>" class="nav-item nav-link text-light">
                             <fmt:message key="create.report" bundle="${bundle}"/></a>
                         <a href="<c:url value="/app/client/taxPayerPage"/>" class="nav-item nav-link text-light">
                             <fmt:message key="my.reports" bundle="${bundle}"/></a>
                     </c:if>

                     <c:if test="${sessionScope.user.role.get() == 'ADMIN'}">
                         <a href="<c:url value="/app/admin/adminPage"/>" class="nav-item nav-link text-light">
                             <fmt:message key="admin.page" bundle="${bundle}"/></a>
                     </c:if>

                     <c:if test="${sessionScope.user.role.get() == 'INSPECTOR'}">
                         <a href="<c:url value="/app/inspector/inspectorPage"/>" class="nav-item nav-link text-light">
                             <fmt:message key="inspector.page" bundle="${bundle}"/></a>
                     </c:if>

                     <c:if test="${empty sessionScope.user}">
                         <a href="<c:url value="/app/loginPage"/>" class="nav-item nav-link text-light">
                             <fmt:message key="login" bundle="${bundle}"/></a>
                     </c:if>

                     <c:if test="${not empty sessionScope.user}">
                         <a href="<c:url value="/app/redirect/logout"/>" class="nav-item nav-link text-light">
                             <fmt:message key="logout" bundle="${bundle}"/></a>
                     </c:if>--%>
                    <div class="nav-item">
                        <form action="app">
                            <input type="hidden" name="command" value="language"/>
                            <select class="input-group" name="lang" onchange="this.form.submit()">
                                <option value="en" ${sessionScope.lang == 'en' ? 'selected="selected"' : ''}>
                                    English
                                </option>
                                <option value="ru" ${sessionScope.lang == 'ru' ? 'selected="selected"' : ''}>
                                    Русский
                                </option>
                            </select>
                        </form>
                    </div>

                </div>
            </nav>
        </div>
    </div>
</header>