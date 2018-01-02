<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value='${sessionScope.locale}'/>
<fmt:setBundle basename="language"/>


    <nav class="navbar navbar-default" >
        <div class="container-fluid">
            <div class="navbar-header">
                    <a class="navbar-brand"  href="/" > Polik Delivery</a>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/polik?command=localeUa">EN</a></li>
                    <li><a href="/polik?command=localeEn">UKR</a></li>
                </ul>
            </div>
            <ul class="nav navbar-nav navbar-right">

                    <a href="/polik?command=registration&registration=Registration">
                        <span class="glyphicon glyphicon-user"></span><fmt:message key="signUp"/>
                    </a>

                    <a href="/polik?command=login&login=Login">
                        <span class="glyphicon glyphicon-log-in"></span><fmt:message key="login"/>
                    </a>
                <c:if test="${not empty sessionScope.user}">
                    <li>
                        <a href="#">
                            <fmt:message key="welcome"/><c:out value="${sessionScope.user.getFirstName()}"/>
                        </a>
                    </li>
                    <li>
                        <a href="/polik?command=logout">
                            <span class="glyphicon glyphicon-log-out"></span><fmt:message key="logout"/>
                        </a>
                    </li>
                </c:if>
            </ul>


        </div>
    </nav>




<%--<li>--%>
    <%--<a href="/polik?command=registration&registration=Registration"><fmt:message key="registration"/> </a>--%>
<%--</li>--%>