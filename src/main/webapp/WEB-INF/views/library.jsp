<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Raluca
  Date: 12.12.2016
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"/>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js" />"></script>
    <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
    <style>
        <%@include file="/resources/css/styles.css"%>
        <%@include file="/resources/js/clock_assets/flipclock.css" %>
    </style>
    <link rel="stylesheet" type="text/css" href="<c:url value="http://fonts.googleapis.com/css?family=Arvo" />">
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }

        /* Add a gray background color and some padding to the footer */
        footer {
            background-color: #f2f2f2;
            padding: 25px;
        }

        .carousel-inner img {
            width: 100%; /* Set width to 100% */
            margin: auto;
            min-height:200px;
        }

        /* Hide the carousel text when the screen is less than 600 pixels wide */
        @media (max-width: 600px) {
            .carousel-caption {
                background-collor: red;
                margin-bottom:-300px;
                display: none;
            }
        }


        li a, .dropbtn {
            display: inline-block;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover, .dropdown:hover .dropbtn {
        }

        li.dropdown {
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {background-color: #f1f1f1}

        .show {display:block;}


    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid" id="top-nav-bar">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav" id="meniu-top">
                <spring:url value="/" var="urlLanding" htmlEscape="true"/>
                <li><a href="${urlLanding}">Home</a></li>
                <li class="active"><a href="#">Bibliotec&#259;</a></li>
                <li><a href="#">Despre noi</a></li>
                <li><a href="#">Contact</a></li>
                <li class="dropdown" id="user">
                    <a href="javascript:void(0)" class="dropbtn" onclick="myFunction()">${firstname} ${lastname}</a>
                    <div class="dropdown-content" id="myDropdown">
                        <a href="/user-details/show-profile" id="profil-btn">Profil</a>
                        <a href="/logout" id="logout-btn">Log out</a>
                    </div>
                </li>
            </ul>

        </div>
    </div>
</nav>
<div class="col-sm-12" id="header-biblioteca">
    <center><label id="titluPagina">BOOKZILLA</label></center>
    <br />
    <center><p id="titluPagina-desc">Caut&#259; in biblioteca noastr&#259;...</p></center>
    <br />

    <form name='searchForm'
          action="<c:url value='/library/search' />" method='POST'>
    <div class="container" id="search">
        <div class="row">
            <div class="col-md-12">
                <div class="input-group" id="adv-search">
                    <input type="text" name="search_key" class="form-control" placeholder="Caut&#259; dup&#259; titlu sau autor..." />
                    <div class="input-group-btn">
                        <div class="btn-group" role="group">
                            <div class="dropdown dropdown-lg">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false"><span class="caret"></span></button>
                                <div class="dropdown-menu dropdown-menu-right" role="menu">
                                    <form class="form-horizontal" role="form">
                                        <div class="form-group">
                                            <label for="filter">Filtreaz&#259; dup&#259;:</label>
                                            <select class="form-control">
                                                <option value="0" selected>Toate c&#259;r&#355;ile</option>
                                                <option value="1">Recomandate</option>
                                                <option value="2">Cele mai populare</option>
                                                <option value="3">Cele mai bine cotate</option>
                                                <option value="4">Cele mai comentate</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="contain">Autor:</label>
                                            <input class="form-control" type="text" />
                                        </div>
                                        <div class="form-group">
                                            <label for="contain">Con&#355;ine cuvintele:</label>
                                            <input class="form-control" type="text" />
                                        </div>
                                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                    </form>
                                </div>
                            </div>
                            <button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-search red" aria-hidden="true"></span></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </form>
</div>

<div class="col-md-3" id="meniu-stanga">
    <!-- uncomment code for absolute positioning tweek see top comment in css -->
    <!-- <div class="absolute-wrapper"> </div> -->
    <!-- Menu -->
    <div class="side-menu">

        <nav class="navbar navbar-default" role="navigation">

            <div class="side-menu-container">
                <ul class="nav navbar-nav">

                    <!-- Dropdown-->
                    <li class="panel panel-default" id="dropdown">
                        <a data-toggle="collapse" href="#dropdown-lvl1">
                            <span class="glyphicon glyphicon-tags"></span> Categorii: <span class="caret"></span>
                        </a>

                        <!-- Dropdown level 1 -->
                        <div id="dropdown-lvl1" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav navbar-nav">
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-camera"></span> Arta si fotografie</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-heart"></span>Beletristica</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-fire"></span>Critica</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-eye-open"></span>Biografii</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-tree-conifer"></span>Memorialistica</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-cd"></span>IT</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-send"></span>Copii</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-globe"></span>Enciclopedie</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-knight"></span>Filozofie</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-hourglass"></span>Istorie</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li class="panel panel-default" id="dropdown">
                        <a data-toggle="collapse" href="#dropdown-lvl2">
                            <span class="glyphicon glyphicon-flag"></span> Limba: <span class="caret"></span>
                        </a>

                        <!-- Dropdown level 1 -->
                        <div id="dropdown-lvl2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav navbar-nav">
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Romana</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Engleza</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Germana</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Franceza</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Spaniola</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Ungara</a>
                                    </li>
                                    <li>
                                        <a href="#"><span class="glyphicon glyphicon-triangle-right"></span>Alte limbi</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>
                    <li class="panel panel-default" id="dropdown">
                        <a data-toggle="collapse" href="#dropdown-lvl3">
                            <span class="glyphicon glyphicon-tree-deciduous"></span> Judet: <span class="caret"></span>
                        </a>
                        <div id="dropdown-lvl3" class="panel-collapse collapse">
                            <div class="panel-body">
                                <ul class="nav navbar-nav">
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl4">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Alba - Bistrita-Nasaud<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl4" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Alba</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Arad</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Arges</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Bacau</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Bihor</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Bistrita-Nasaud</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl5">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Botosani - Caras-Severin<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl5" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Botosani</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Brasov</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Braila</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Bucuresti</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Buzau</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Caras-Severin</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl6">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Calarasi - Dolj<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl6" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Calarasi</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Cluj</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Constanta</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Covasna</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Dambovita</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Dolj</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl7">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Galati - Ialomita<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl7" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Galati</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Giurgiu</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Gorj</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Harghita</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Hunedoara</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Ialomita</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl8">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Iasi - Neamt<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl8" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Iasi</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Ilfov</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Maramures</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Mehedinti</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Mures</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Neamt</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl9">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Olt - Suceava<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl9" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Olt</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Prahova</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Satu Mare</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Salaj</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Sibiu</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Suceava</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <a data-toggle="collapse" href="#dropdown-lvl10">
                                            <span class="glyphicon glyphicon-triangle-right"></span>Teleorman - Vrancea<span class="caret"></span>
                                        </a>
                                        <div id="dropdown-lvl10" class="panel-collapse collapse">
                                            <div class="panel-body">
                                                <ul class="nav navbar-nav">
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Teleorman</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Timis</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Tulcea</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Vaslui</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Valcea</a></li>
                                                    <li><a href="#"><span class="glyphicon glyphicon-menu-right"></span>Vrancea</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>

    </div>
</div>

<div class="col-md-9" id="content">
    <div class="col-md-12">
        <label id="titluRecomandari">Recomand&#259;ri:</label>
        <br />
    </div>
    <div class="col-md-12">
        <div class="row">

            <c:forEach items="${allBooks}" var="book">
                <a href="<c:url value="/book-details/${book.id}" />">
                    <div class="col-md-2">
                        <img src="<c:url value="${book.url}" /> " id="recImg"/>
                    </div>
                </a>
            </c:forEach>

            <c:forEach items="${matchedBooks}" var="matchedBook">
                <a href="<c:url value="/book-details/${matchedBook.id}" />">
                    <div class="col-md-2">
                        <img src="<c:url value="${matchedBook.url}" /> " id="recImg"/>
                    </div>
                </a>
            </c:forEach>

            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>

            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>
            <%--</div>--%>
            <%--<div class="col-md-2">--%>
                <%--<img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>--%>
            <%--</div>--%>
        </div>
    </div>
</div>

<div class="col-md-9" id="content">
    <div class="col-md-12">
        <label id="titluRecomandari">Popular &#238;n zona ta:</label>
        <br />
    </div>
    <div class="col-md-12">
        <div class="row">
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
            </div>
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>

            </div>
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
            </div>
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
            </div>
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
            </div>
            <div class="col-md-2">
                <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
            </div>
        </div>
    </div>
</div>

<script>
    /* When the user clicks on the button,
     toggle between hiding and showing the dropdown content */
    function myFunction() {
        document.getElementById("myDropdown").classList.toggle("show");
    }

    // Close the dropdown if the user clicks outside of it
    window.onclick = function(e) {
        if (!e.target.matches('.dropbtn')) {

            var dropdowns = document.getElementsByClassName("dropdown-content");
            for (var d = 0; d < dropdowns.length; d++) {
                var openDropdown = dropdowns[d];
                if (openDropdown.classList.contains('show')) {
                    openDropdown.classList.remove('show');
                }
            }
        }
    }
</script>
</body>
</html>
