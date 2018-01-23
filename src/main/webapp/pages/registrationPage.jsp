<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>

<fmt:message key="registration.title" var="Title"/>
<fmt:message key="registration.registration" var="Registration"/>
<fmt:message key="registration.lUsername" var="Username"/>
<fmt:message key="registration.lPassword" var="Password"/>
<fmt:message key="registration.lFirstName" var="FirstName"/>
<fmt:message key="registration.lSecondName" var="SecondName"/>
<fmt:message key="registration.lEmail" var="Email"/>
<fmt:message key="registration.lAddress" var="Address"/>
<fmt:message key="registration.lPhone" var="Phone"/>
<fmt:message key="registration.lCity" var="City"/>
<fmt:message key="registration.lHome" var="Home"/>
<fmt:message key="registration.iRegistration" var="iRegistration"/>

<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${Title}</title>
    <link rel="stylesheet" type="text/css" href="../css/registrationF.css">
</head>
<body>
<%--REGISTRATION--%>
<section id="registrrationForm" class="registrationForm">
    <div class="existUsername">
        <c:choose>
            <c:when test="${usernameBoolean == true}">
                ${usernameException}
            </c:when>
            <c:when test="${passwordBoolean == true}">
                ${passwordException}
            </c:when>
            <c:when test="${emailBoolean == true}">
                ${emailException}
            </c:when>
            <c:otherwise>
                <div class="createUser">
                        ${createUser}
                </div>
            </c:otherwise>
        </c:choose>

        ${existUsername}
    </div>

    <div class="box">
        <h2>${Registration}</h2>
        <form action="con" method="post" name="registrationForm">
            <div class="inputWrap">
                <div class="inputWrap__element">
                    <div class="inputBox">
                        <input type="text" name="username" required="">
                        <label>${Username}</label>
                    </div>
                    <div class="inputBox">
                        <input type="password" name="password" required="">
                        <label>${Password}</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="firstName" required="">
                        <label>${FirstName}</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="secondName" required="">
                        <label>${SecondName}</label>
                    </div>
                </div>
                <div class="inputWrap__element">
                    <div class="inputBox">
                        <input type="email" name="email" required="">
                        <label>${Email}</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="address" required="">
                        <label>${Address}</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="city" required="">
                        <label>${City}</label>
                    </div>
                    <div class="inputBox">
                        <input type="text" name="phone" required="">
                        <label>${Phone}</label>
                    </div>
                </div>
            </div>
            <div class="regInput">
                <a href="/">${Home}</a>
                <input type="submit" value="${iRegistration}">
                <input type="hidden" name="command" value="registration">
            </div>
        </form>
    </div>
</section>
<%--/REGISTRATION--%>

</body>
</html>
