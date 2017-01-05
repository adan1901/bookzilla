<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <style> <%@include file="/resources/css/styles.css" %> </style>
    <style> <%@include file="/resources/css/profil.css" %> </style>

</head>
<body>
<div id="logo">
    <a href="<c:url value="/"/>"><img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:10%;margin-top:1%; margin-bottom: 1%"/></a>
</div>
<div id="labelUser">
    <%--<label id="user">${name}</label>--%>
    <input type="button" id="logout" style="margin-right:2%" onclick="location.href='/logout';" value="Log Out" />
</div>
<hr/>


<section id="about" class="section-content about">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <figure class="fig-profile wow fadeIn" style="visibility: visible; animation-name: fadeIn;">
                    <img class="img-responsive img-circle img-profile" src="http://static.wixstatic.com/media/15b0f6_eadfe405ec674ef3b5f7fd14b2804ed8~mv2.jpg_256">
                    <figcaption>Hello !</figcaption>
                </figure>

                <h2 class="name"><b>${lastName}</b> ${firstName}</h2>
                <h3 class="position">Telefon: 0722334556</h3>
                <h4 class="text-center location">Bucharest, Romania</h4>
                <div class="title-divider">
                    <span class="hr-divider col-xs-5"></span>
                    <span class="icon-separator col-xs-2"><i class="fa fa-star"></i></span>
                    <span class="hr-divider col-xs-5"></span>
                </div>

            </div>

            <div class="col-md-8 col-md-offset-2 text-center">
               <h1 class="slogan">BIBLIOTECA PERSONALA</h1>
                <br />
                <c:forEach items="${bookCollection}" var="book">
                    <a href="/book-details/${book.id}">
                        <img src="${book.url}" style="margin-left:10px;width:180px;height:200px;float:left;margin-top:10px;" />
                    </a>
                </c:forEach>

                <c:if test="${userIsPriviliged}">
                    <a href="<c:url value="/add-book"/>">
                        <button type="button" class="buttonLogIn" id="addBook" style="margin-left:45%">Adauga o carte</button>
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</section>

