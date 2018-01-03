<%--
  Created by IntelliJ IDEA.
  User: olexandr
  Date: 02.01.18
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Polik</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/terms.css">
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
                        <li  class="active"><a href="/pages/conditionPage.jsp">Умови&nbspдоставки</a></li>
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
                    <li>
                        <a href="/pages/loginPage.jsp">Sign&nbspin <i class=" fa fa-sign-in"></i></a>
                    </li>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->
<!-- TERMS OF DELIVRRY -->
<section id="terms" class="terms">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Умови доставки</h2>
            </div>
            <div class="col-lg-12">
                <div class="terms__text">
                    <p>При оформлении заказа до 12.00 и наличии его на складе,
                        мы отправляем товар в тот же день.</p>
                    <p>Уведомление об отправке с номером декларации, отправим
                        Вам с помощью СМС.</p>
                    <p>Доставляется заказ в течении 2 дней, в зависимости от
                        вашего месторасположения.</p>
                    <p>Как только товар поступит в отделение "Polik Delivery" -
                        вы получите извещение СМС сообщением. Вы сможете забрать
                        товар в любое удобное, для вас время на протяжении 4 дней.</p>
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /TERMS OF DELIVRRY -->
<!-- MAP -->
<section id="map" class="map">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-8">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737" width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-lg-4">
                <div class="adress ">
                    01032 г. Киев ул. Гончара 55а (063)-625-48-22
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
                    &#169; 2017 Все права защищены
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>