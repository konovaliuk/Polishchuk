<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language"/>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Polik Delivery</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login">login</a></li>
            <li><a href="registration">regist</a></li>
        </ul>
    </div>
</nav>
    <%--<nav class="navbar navbar-default" >--%>
        <%--<div class="container-fluid">--%>
            <%--<div class="navbar-header">--%>
                <%--<form action="/">--%>

                    <%--<a class="navbar-brand"  href="login" > Polik Delivery</a>--%>
                <%--</form>--%>
            <%--</div>--%>
            <%--<ul class="nav navbar-nav">--%>
                <%--<li>--%>
                    <%--<a href="${pageContext.request.contextPath}/home"><fmt:message key="home"/> </a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="${pageContext.request.contextPath}/registration"><fmt:message key="registration"/> </a>--%>
                <%--</li>--%>
                <%--<li>--%>
                    <%--<a href="/login"><fmt:message key="login"/> </a>--%>
                <%--</li>--%>

            <%--</ul>--%>

        <%--</div>--%>
    <%--</nav>--%>

