<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>

<fmt:message key="login.placeholderUsername" var="Username"/>
<fmt:message key="login.placeholderPassword" var="Password"/>
<fmt:message key="login.rememberMe" var="Remember"/>
<fmt:message key="login.registration" var="Registration"/>
<fmt:message key="login.submit" var="Submit"/>
<fmt:message key="login.signIn" var="SignIn"/>
<fmt:message key="login.invalidMessage" var="InvalidMessage"/>
<fmt:message key="login.home" var="Home"/>


<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
                        <input type="text" id="inputUsername" required="" name="username" autocomplete="off">
                        <label for="inputUsername">${Username} </label>
                    </div>
                    <div class="form-group">
                        <input type="password" id="inputPassword" required="" name="password" autocomplete="off">
                        <label for="inputPassword">${Password} </label>
                    </div>
                    <div class="btn-login">
                        <button type="submit" class="btn btn-success btn-block">${Submit}</button>
                        <a href="con?command=forRegist"> ${Registration}</a>
                        <a href="con?command=home">${Home}</a>
                    </div>
                </form>
                <!-- form end -->
                <div class="wrongUsername">
                    ${wrongUsername} <br/>
                    ${wrongPassword}
                </div>


            </div>
            <div class="col-md-4 col-sm-4 col-xs-12"></div>
        </div>
    </div>
</section>
<%--LOGIN FORM--%>
</body>
</html>