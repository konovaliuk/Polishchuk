
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/jorik.css">
    <link rel="stylesheet" href="../css/calculator.css">
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
                        <li class="active"><a href="/pages/calculatorPage.jsp">Калькулятор&nbspдоставки</a></li>
                        <li><a href="/pages/contactsPage.jsp">Контакти</a></li>
                        <li><a href="/pages/orderPage.jsp">Створити&nbspзаявку</a></li>
                    </ul>
                </nav>
            </div>
            <div class="col-lg-3 d-flex justify-content-end ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="?command=localeEn">En</a></span>
                    <a href="/pages/loginPage.jsp">Sign&nbspin <i class=" fa fa-sign-in"></i></a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- /MENU -->
<!-- CALCULATOR -->
<section id="calculator" class="calculator">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>Калькулятор</h2>
            </div>
        </div>
        <form action="#">
            <div class="row align-items-center">
                <div class="col-lg-4 d-flex justify-content-center">
                    <label >Маршрут:</label>
                </div>
                <div class="col-lg-3 d-flex justify-content-center">
                    <select name="from_city" id="from">
                        <option value="Kiev">Киев</option>
                        <option value="Odessa">Одесса</option>
                        <option value="Lviv">Львов</option>
                    </select>
                </div>
                <div class="col-lg-1 d-flex justify-content-center">
                    <i class="fa fa-arrow-right"></i>
                </div>
                <div class="col-lg-3">
                    <select name="to_city" id="to">
                        <option value="Kiev">Киев</option>
                        <option value="Odessa">Одесса</option>
                        <option value="Lviv">Львов</option>
                    </select>
                </div>
                <div class="col-lg-4 d-flex justify-content-center">
                    <label>Дата отправления:</label>
                </div>
                <div class="col-lg-2">
                    <input type="text" required="">
                </div>
                <div class="col-lg-2 d-flex justify-content-center">
                    <label>Ориентировочная дата получения:</label>
                </div>
                <div class="col-lg-2">
                    <input type="text" required="">
                </div>
                <div class="col-lg-4 d-flex justify-content-center">
                    <label>Обьявленая стоимость:</label>
                </div>
                <div class="col-lg-8">
                    <input type="number" required="">
                </div>
                <div class="col-lg-4 d-flex justify-content-center">
                    <label>Вес:</label>
                </div>
                <div class="col-lg-8">
                    <input type="number" required="">
                </div>
                <div class="col-lg-4 d-flex justify-content-center">
                    <label>Обьем:</label>
                </div>
                <div class="col-lg-8">
                    <input type="number" required="">
                </div>
            </div>
            <div class="offset-lg-4 col-lg-4">
                <input type="submit" value="Расчитать">
            </div>
            <div class="row">
                <div class="col-lg-12"><h2></h2></div>
                <div class="col-lg-3 d-flex justify-content-center">
                    <i class="fa fa-calculator"></i>
                </div>
                <div class="col-lg-5">
                    <h3>Расчет стоимости:</h3>
                    <span>Стоимость доставки:</span>
                </div>
                <div class="col-lg-4">
                    <h3>Стоимость:</h3>
                    <span>1000 грн.</span>
                </div>
                <div class="offset-lg-3 col-lg-5">
                    <h3>Итого к оплате:</h3>
                </div>
                <div class="col-lg-4">
                    <h3>1000 грн.</h3>
                </div>
            </div>
        </form>
    </div>
</section>
<!-- CALCULATOR -->
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
