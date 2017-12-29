<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language" />


<html>
<head>
    <jsp:include page="/WEB-INF/includeJSP/header.jsp"/>
</head>
<body>
<jsp:include page="/WEB-INF/includeJSP/navbar.jsp"/>
<div class="row">
    <div class="col-md-5"></div>
    <div class="col-md-2" style="text-align: center;">
        <p class="message"><fmt:message key="notregistered" />
            <a href="<c:url value="/pages/registration.jsp"/>">
                <fmt:message key="signUp" /></a></p>
    </div>
    <div class="col-md-5"></div>
</div>


home jsp
<div class="well">
    <fmt:message key="description"/>
</div>

<jsp:include page="/WEB-INF/includeJSP/footer.jsp"/>
</body>
</html>
