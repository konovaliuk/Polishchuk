<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<jsp:useBean id="nowDate" class="ua.com.delivery.service.DateService"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Order Delivery</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/mainPolik.css">
    <link rel="stylesheet" href="../css/orderPolik.css">
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
                    <h1>Polik
                        <small>Доставка грузов</small>
                    </h1>
                </div>
            </div>
            <div class="col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>Расписание работы Пн - Сб: 9<sup>00</sup> &#8212; 21<sup>00</sup></p>
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
                        <li><a href="/con?command=condition">Умови&nbspдоставки</a></li>
                        <li><a href="/con?command=calculator">Калькулятор&nbspдоставки</a></li>
                        <li><a href="/con?command=contact">Контакти</a></li>
                        <li class="active"><a href="/con?command=order">Створити&nbspзаявку</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 d-flex justify-content-end ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="?command=localeEn">En</a></span>
                    <a href="/con?command=signIn">Sign&nbspin <i class=" fa fa-sign-in"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->

<!-- ORDER -->
<section id="order" class="order">
    <div class="container">
        <div class="row ">
            <div class="col-lg-12">
                <h2>Мій кабінет</h2>
                <!-- Line -->
                <div class="line"></div>
                <!-- /Line -->
                <input type="checkbox" id="test">
                <label class="myButton" for="test">Створити заявку</label>
                <input class="myButton" type="button" value="Оплатити">
                <!-- Line -->
                <div class="line"></div>
                <!-- /Line -->
                <form action="#">
                    <!-- Забор груза -->
                    <div class="col-lg-12 d-flex justify-content-center">
                        <input type="radio" name="type" id="receipt">
                        <label for="receipt">Забор груза</label>
                        <div class="receiptTab">
                            <div class="receiptTab__element">
                                <label for="recDate">Дата забора:</label>
                                <input class="forDate" type="date" id="recDate"
                                       min="<jsp:getProperty name="nowDate" property="date"/>"
                                       required="">
                                <label for="recPhone">Телефон:</label>
                                <input type="text" id="recPhone" required="">
                            </div>
                            <div class="receiptTab__element">
                                <label for="recCity">Город:</label>
                                <input type="text" id="recCity" required="">
                                <label for="recAdress">Адрес доставки:</label>
                                <input type="text" id="recAdress" required="">
                            </div>
                            <div class="receiptTab__element">
                                <label for="recLast">Фамилия:</label>
                                <input type="text" id="recLast" required="">
                                <label for="recWeight">Вес груза:</label>
                                <input type="text" id="recWeight" required="">
                            </div>
                            <div class="receiptTab__element">
                                <label for="recName">Имя:</label>
                                <input type="text" id="recName" required="">
                                <label for="recVolume">Обьем груза:</label>
                                <input type="text" id="recVolume" required="">
                            </div>
                            <div class="receiptTab__element">
                                <label for="recEmail">E-mail:</label>
                                <input type="text" id="recEmail" required="">
                            </div>
                        </div>
                    </div>
                    <!-- /Забор груза -->
                    <!-- Line -->
                    <div class="line"></div>
                    <!-- /Line -->
                    <!-- Доставка груза -->
                    <div class="col-lg-12 d-flex justify-content-center">
                        <input type="radio" name="type" id="delivery">
                        <label for="delivery">Доставка груза</label>
                        <div class="deliveryTab">
                            <div class="deliveryTab__element">
                                <label for="delDate">Дата забора:</label>
                                <input class="forDate" type="date" id="delDate"
                                       min="<jsp:getProperty name="nowDate" property="date"/>"
                                       required="">
                                <label for="delPhone">Телефон:</label>
                                <input type="text" id="delPhone" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <label for="delCity">Город:</label>
                                <input type="text" id="delCity" required="">
                                <label for="delAdress">Адрес доставки:</label>
                                <input type="text" id="delAdress" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <label for="delLast">Фамилия:</label>
                                <input type="text" id="delLast" required="">
                                <label for="delWeight">Вес груза:</label>
                                <input type="text" id="delWeight" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <label for="delName">Имя:</label>
                                <input type="text" id="delName" required="">
                                <label for="delVolume">Обьем груза:</label>
                                <input type="text" id="delVolume" required="">
                            </div>
                            <div class="deliveryTab__element">
                                <label for="delEmail">E-mail:</label>
                                <input type="text" id="delEmail" required="">
                            </div>
                        </div>
                    </div>
                    <!-- /Доставка груза -->
                    <!-- Line -->
                    <div class="line"></div>
                    <!-- /Line -->
                    <div class="offset-lg-5 col-lg-6">
                        <div class="price d-flex justify-content-around align-items-center">
                            <h3>Стоимость:</h3>
                            <p>1000 грн.</p>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <input type="submit" value="Відправити заявку">
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- ORDER -->
<!-- MAP -->
<section id="map" class="map">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-8">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737"
                        width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-lg-4">
                <div class="address ">
                    01032 м.Киев вул. Гончара 55а (063)-625-48-22
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