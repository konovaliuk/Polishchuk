<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<fmt:setBundle basename="language"/>

<fmt:message key="condition.delivery" var="Delivery"/>
<fmt:message key="condition.schedule" var="Schedule"/>
<fmt:message key="condition.main" var="Main"/>
<fmt:message key="condition.condition" var="Condition"/>
<fmt:message key="condition.calculator" var="Calculator"/>
<fmt:message key="condition.contacts" var="Contact"/>
<fmt:message key="condition.order" var="Order"/>
<fmt:message key="condition.signIn" var="SignIn"/>
<fmt:message key="condition.first" var="firstPar"/>
<fmt:message key="condition.second" var="secondPar"/>
<fmt:message key="condition.third" var="thirdPar"/>
<fmt:message key="condition.fourth" var="fourthPar"/>
<fmt:message key="condition.tariffing" var="tariffingPar"/>
<fmt:message key="condition.from" var="from"/>
<fmt:message key="condition.to" var="to"/>
<fmt:message key="condition.price" var="price"/>
<fmt:message key="condition.address" var="address"/>
<fmt:message key="condition.allRight" var="allRight"/>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Polik</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../css/mainPolik.css">
    <link rel="stylesheet" href="../css/conditionPolik.css">
    <link rel="stylesheet" href="../css/media.css">

</head>
<body>
<!-- HEADER -->
<header id="header" class="header">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-md-8 col-lg-7 d-flex">
                <div class="logo">
                    <img src="img/logo.png" alt="logo" width="100">
                </div>
                <div class="logo__text">
                    <h1>Polik <small>${Delivery}</small></h1>
                </div>
            </div>
            <div class="col-md-4 col-lg-3 ml-auto">
                <div class="schedule">
                    <span>(063)-625-48-22</span>
                    <p>${Schedule} 9<sup>00</sup> &#8212; 21<sup>00</sup> </p>
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
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
            </div>
            <div class="col-md-9 col-lg-9">
                <input type="checkbox" id="hideMenu">
                <label for="hideMenu"><i class="fa fa-bars"></i></label>
                <nav>
                    <ul class="menu d-flex">
                        <li><a href="/con?command=home">${Main}</a ></li>
                        <li class="active"><a href="/con?command=condition">${Condition}</a></li>
                        <li><a href="/con?command=calculator">${Calculator}</a></li>
                        <li><a href="/con?command=contact">${Contact}</a></li>
                        <c:if test="${visible == true}">
                            <li><a href="/con?command=order">${Order}</a></li>
                        </c:if>
                        <%--<li><a href="/con?command=order">${Order}</a></li>--%>
                    </ul>
                </nav>
            </div>
            <div class="col-md-3 col-lg-3 d-flex justify-content-end align-items-center ml-auto">
                <div class="lang">
                    <span class="lang__item"><a href="/con?command=localeUa">Укр</a></span>
                    <span class="lang__item"><a href="/con?command=localeEn">En</a></span>
                    <c:choose>
                        <c:when test="${visibleLogout == true}">
                            <a href="/con?command=logout">${Logout}<i class="fa fa-sign-out"></i> </a>
                        </c:when>
                        <c:otherwise>
                            <a href="/con?command=signIn">${SignIn} <i class=" fa fa-sign-in"></i></a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <div class="col-md-12 col-lg-12">
                <div class="line"></div>
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
                <h2>${Condition}</h2>
            </div>
            <div class="col-lg-12">
                <div class="terms__text">
                    <p>${firstPar}</p>
                    <p>${secondPar} </p>
                    <p>${thirdPar}</p>
                    <p>${fourthPar}(063)-625-48-22 </p>
                </div>
                <div class="terms__priceList">
                    <table>
                        <thead>
                        <tr>
                            <th colspan="3">${tariffingPar}</th>
                        </tr>
                        <tr>
                            <th>${from}</th>
                            <th>${to}</th>
                            <th>${price}</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listPrice}" var="elem">
                            <tr>
                                <td><c:out value="${elem.fromCity}"/></td>
                                <td><c:out value="${elem.toCity}"/></td>
                                <td><c:out value="${elem.priceDirection}"/></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
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
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d2540.540206722022!2d30.50255354272231!3d50.44966448382961!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sru!2sua!4v1513559315737"
                        width="100%" height="250" frameborder="0" style="border:0" allowfullscreen></iframe>
            </div>
            <div class="col-lg-4">
                <div class="address">
                    01032 ${address} (063)-625-48-22
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
                    &#169; 2017 ${allRight}
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- /FOOTER -->
</body>
</html>