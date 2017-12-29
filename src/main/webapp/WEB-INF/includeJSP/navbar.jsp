<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language"/>

    <nav class="navbar navbar-default" >
        <div class="container-fluid">
            <div class="navbar-header">
                <form action="/">

                    <a class="navbar-brand"  href="/" > Polik Delivery</a>
                </form>
            </div>
            <ul class="nav navbar-nav">
                <li>
                    <%--<a href="${pageContext.request.contextPath}home"><fmt:message key="home"/> </a>--%>
                        <a href="/polik?command=home"><fmt:message key="home"/> </a>
                </li>
                <li>
                    <a href="/polik?command=registration&registration=Registration"><fmt:message key="registration"/> </a>
                </li>
                <li>
                    <a href="/polik?command=login"><fmt:message key="login"/> </a>
                </li>

            </ul>

        </div>
    </nav>

