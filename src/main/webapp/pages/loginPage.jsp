<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language"/>

<fmt:message key="login.placeholderUsername" var="Username"/>
<fmt:message key="login.placeholderPassword" var="Password"/>
<fmt:message key="login.rememberMe" var="Remember"/>
<fmt:message key="login.registration" var="Registration"/>
<fmt:message key="login.submit" var="Submit"/>
<fmt:message key="login.signIn" var="SignIn"/>
<fmt:message key="login.invalidMessage" var="InvalidMessage"/>


<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" type="text/css" href="../css/signInPolik.css">

</head>
<body>
<%--LOGIN FORM--%>
<section id="loginForm" class="loginForm">
    <div class="container-fluid bg">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
            <div class="col-md-4 col-sm-4 col-xs-12">
                <!-- form start -->
                <form class="form-container" method="post" action="con" name="loginForm">
                    <input type="hidden" name="command" value="login">
                    <h1>${SignIn}</h1>
                    <div class="form-group">
                        <input type="text" id="inputUsername" required="" name="username">
                        <label for="inputUsername">${Username} </label>
                    </div>
                    <div class="form-group">
                        <input type="password" id="inputPassword" required="" name="password">
                        <label for="inputPassword">${Password} </label>
                    </div>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox"> ${Remember}
                        </label>
                    </div>
                    <div class="btn-login">
                        <button type="submit" class="btn btn-success btn-block" <%--name="sub" value="sub"--%>>${Submit}</button>
                        <a href="/pages/registrationPage.jsp"> ${Registration}</a>
                    </div>
                    <%--<c:if test="${requestScope.errorMessage != null}">--%>
                        <%--<h4>${InvalidMessage} /></h4>--%>
                    <%--</c:if>--%>
                </form>
                <!-- form end -->
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
        </div>
    </div>
</section>
<%--LOGIN FORM--%>
</body>
</html>