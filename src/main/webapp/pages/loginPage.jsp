<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link rel="stylesheet" type="text/css" href="../css/jorik.css">
    <link rel="stylesheet" type="text/css" href="../css/valerchik.css">

</head>
<body>
<!-- HEADER -->
<header id="header" class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-7 d-flex">
                <div class="logo">
                    <img src="../img/logo.png" alt="logo" width="100">
                </div>
                <div class="logo__text">
                    <h1>Polik <small>Доставка грузов</small></h1>
                </div>
            </div>
            <div class="col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>Расписание работы Пн - Сб: 9<sup>00</sup> &#8212; 21<sup>00</sup> </p>
                </div>
            </div>
        </div>
    </div>
</header>
<!-- /HEADER -->
<!-- MENU -->
<section id="topMenu" class="topMenu">
    <div class="container">
        <div class="row">
            <div class="col-lg-9">
                <nav>
                    <ul class="menu d-flex">
                        <li><a href="/">Главная</a></li>
                        <li><a href="/pages/conditionPage.jsp">Умови&nbspдоставки</a></li>
                        <li><a href="/pages/calculatorPage.jsp">Калькулятор&nbspдоставки</a></li>
                        <li><a href="/pages/contactsPage.jsp">Контакти</a></li>
                        <li><a href="/pages/orderPage.jsp">Створити&nbspзаявку</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 d-flex justify-content-end ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="?command=localeEn">En</a></span>
                    <li class="active">
                        <a href="/pages/loginPage.jsp">Sign&nbspin <i class=" fa fa-sign-in"></i></a>
                    </li>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->

<div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">
            <!-- form start -->
            <form class="form-container" method="post" action="polik" name="loginForm">
                <input type="hidden" name="command" value="login">
                <h1>Sign in</h1>
                <div class="form-group">
                    <input type="text" id="inputUsername" required="">
                    <label for="inputUsername"><fmt:message key="placeholderUsername" /> </label>
                </div>
                <div class="form-group">
                    <input type="password" id="inputPassword" required="">
                    <label for="inputPassword"><fmt:message key="placeholderPassword" /> </label>
                </div>

                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
                <button type="submit" class="btn btn-success btn-block" name="login" value="Login">Submit</button>
                <a href="/pages/registrationPage.jsp"> Зареєструватися</a>
            </form>
            <!-- form end -->
        </div>
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
    </div>
</div>
</body>
</html>