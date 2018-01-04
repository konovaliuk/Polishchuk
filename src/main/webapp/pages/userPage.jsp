<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>


<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="language"/>

<fmt:message key="userPage.delivery" var="Delivery"/>
<fmt:message key="userPage.schedule" var="Schedule"/>
<fmt:message key="userPage.main" var="Main"/>
<fmt:message key="userPage.condition" var="Condition"/>
<fmt:message key="userPage.calculator" var="Calculator"/>
<fmt:message key="userPage.contacts" var="Contact"/>
<fmt:message key="userPage.order" var="Order"/>
<fmt:message key="userPage.logout" var="Logout"/>


<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/mainPolik.css">
    <title>Polik Delivery</title>
</head>
<body>
<!-- HEADER -->
<header id="header" class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-7 d-flex">
                <div class="logo">
                    <img src="img/logo.png" alt="logo" width="100">
                </div>
                <div class="logo__text">
                    <h1>Polik <small>${Delivery}</small></h1>
                </div>
            </div>
            <div class="col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>${Schedule} 9<sup>00</sup> &#8212; 21<sup>00</sup> </p>
                    <p>Hello my friend, <b>${user}</b></p>
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
            <div class="col-lg-12">
                <div class="line"></div>
            </div>
            <div class="col-lg-9">
                <nav>
                    <ul class="menu d-flex align-items-center">
                        <li class="active"><a href="/con?command=home" >${Main}</a ></li>
                        <li><a href="/con?command=condition">${Condition}</a></li>
                        <li><a href="/con?command=calculator">${Calculator}</a></li>
                        <li><a href="/con?command=contact">${Contact}</a></li>
                        <li><a href="/con?command=order">My cabinet</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 d-flex justify-content-end align-items-center ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="/con?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="/con?command=localeEn">En</a></span>
                    <a href="/con?command=logout">${Logout} <i class=" fa fa-sign-in"></i></a>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="line"></div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->
<!-- SLIDER -->
<section id="slider" class="slider">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="slides">
                    <ul class="slides__item d-flex">
                        <li><img src="img/1.jpg" alt="1"></li>
                        <li><img src="img/2.jpeg" alt="2"></li>
                        <li><img src="img/3.jpg" alt="3"></li>
                        <li><img src="img/4.jpg" alt="4"></li>
                        <li><img src="img/5.jpg" alt="5"></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /SLIDER -->
<!-- INFO -->
<section id="info" class="info">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <h2>Інформація</h2>
                <p>Lorem ipsum dolor sit amet,
                    consectetur adipisicing elit.
                    Fuga, commodi ea consectetur tempore
                    velit voluptates voluptatibus quaerat
                    quo veritatis, ut architecto veniam.
                    Voluptas obcaecati dolorem, quos.
                    Qui illo quas, sunt.</p>
            </div>
            <div class="col-lg-4">
                <h2>Гарантії</h2>
                <p>Lorem ipsum dolor sit amet,
                    consectetur adipisicing elit.
                    Fuga, commodi ea consectetur tempore
                    velit voluptates voluptatibus quaerat
                    quo veritatis, ut architecto veniam.
                    Voluptas obcaecati dolorem, quos.
                    Qui illo quas, sunt.</p>
            </div>
            <div class="col-lg-4">
                <h2>Відгуки</h2>
                <p>Lorem ipsum dolor sit amet,
                    consectetur adipisicing elit.
                    Fuga, commodi ea consectetur tempore
                    velit voluptates voluptatibus quaerat
                    quo veritatis, ut architecto veniam.
                    Voluptas obcaecati dolorem, quos.
                    Qui illo quas, sunt.</p>
            </div>
            <div class="col-lg-12">
                <div class="line"></div>
            </div>
        </div>
    </div>
</section>
<!-- /INFO -->
<!-- MAP -->
<section id="map" class="map">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-8">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737" width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-lg-4">
                <div class="address ">
                    01032 м.Київ вул. Гончара 55а (063)-625-48-22
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MAP -->
<!-- FOOTER -->
<footer id="footer" class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="copy">
                    &#169; 2017 Всі права захищені
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>