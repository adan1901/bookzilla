<%--
  Created by IntelliJ IDEA.
  User: Raluca
  Date: 12.12.2016
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <style>
        <%@include file="styles/styles.css" %>
        <%@include file="clock_assets/flipclock.css" %>

    </style>


    <title>BOOKZILLA</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Arvo">


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
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
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
                <li class="active"><a href="landing.html">Home</a></li>
                <li><a href="index.html">Bibliotec&#259;</a></li>
                <li><a href="#">Despre noi</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="login.html"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>

        </div>
    </div>
</nav>



<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
        <li data-target="#myCarousel" data-slide-to="3"></li>
        <li data-target="#myCarousel" data-slide-to="4"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">


        <div class="item active">
            <div class="carousel-caption">
                <div style="margin-top:-600px" id="titlu-one">BOOKZILLA</div>
                <br />
                <div id="desc-one">C&#259;r&#355;ile sunt mai aproape ca oric&#226;nd!</div>
            </div>
            <img src="/images/1.jpg" alt="Image" style="width:100%;height:1000px;">

        </div>

        <div class="item">
            <img src="/images/2.jpg" alt="Image" style="width:100%;height:1000px;">
            <div class="carousel-caption">
                <div style="margin-top:-600px" id="titlu-one">BOOKZILLA</div>
                <br />
                <div id="desc-one">C&#259;r&#355;ile sunt mai aproape ca oric&#226;nd!</div>
            </div>
        </div>

        <div class="item">
            <img src="/images/3.jpg" alt="Image" style="width:100%;height:1000px;">
            <div class="carousel-caption">
                <div style="margin-top:-600px" id="titlu-one">BOOKZILLA</div>
                <br />
                <div id="desc-one">C&#259;r&#355;ile sunt mai aproape ca oric&#226;nd!</div>
            </div>
        </div>

        <div class="item">
            <img src="/images/4.jpg" alt="Image" style="width:100%;height:1000px;">
            <div class="carousel-caption">
                <div style="margin-top:-600px" id="titlu-one">BOOKZILLA</div>
                <br />
                <div id="desc-one">C&#259;r&#355;ile sunt mai aproape ca oric&#226;nd!</div>
            </div>
        </div>

        <div class="item">
            <img src="/images/5.jpg" alt="Image" style="width:100%;height:1000px;">
            <div class="carousel-caption">
                <div style="margin-top:-600px" id="titlu-one">BOOKZILLA</div>
                <br />
                <div id="desc-one">C&#259;r&#355;ile sunt mai aproape ca oric&#226;nd!</div>
            </div>
        </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div id="about-us">
    <div class="container text-center">
        <br />
        <div id="titlu-about">Ce face BOOKZILLA?</div><br />
        <div class="row">
		<span class="col-sm-4" id="wrapper">
		  <img src="/images/a1.jpg" class="img-responsive hover" style="width:100%" alt="Image">
		</span>
            <div class="col-sm-4" id="wrapper">
                <img src="/images/a2.jpg" class="img-responsive hover" style="width:100%" alt="Image">
            </div>
            <div class="col-sm-4" id="wrapper">
                <img src="/images/a3.jpg" class="img-responsive hover" style="width:100%" alt="Image">
            </div>
        </div>
        <br/>
        <div class="row">
            <div class="col-sm-4" id="wrapper">
                <img src="/images/a4.jpg" class="img-responsive hover" style="width:100%" alt="Image">
            </div>
            <div class="col-sm-4" id="wrapper">
                <img src="/images/a5.jpg" class="img-responsive hover" style="width:100%" alt="Image">
            </div>
            <div class="col-sm-4" id="wrapper">
                <img src="/images/a6.jpg" class="img-responsive hover" style="width:100%" alt="Image">
            </div>
        </div>
        <br />
    </div>
</div>

<div class="text-center" id="timer-line">
    <br />
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-3">
            <div id="timer-text">TIMP PÂNĂ LANSĂM:</div>
        </div>
        <div class="col-sm-6">
            <center><div class="clock-builder-output"></div></center>
            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <script type="text/javascript" src="clock_assets/flipclock.js"></script>
            <style text="text/css">body .flip-clock-wrapper ul li a div div.inn, body .flip-clock-small-wrapper ul li a div div.inn { color: #CCCCCC; background-color: #333333; } body .flip-clock-dot, body .flip-clock-small-wrapper .flip-clock-dot { background: #323434; } body .flip-clock-wrapper .flip-clock-meridium a, body .flip-clock-small-wrapper .flip-clock-meridium a { color: #323434; }</style>
            <script type="text/javascript">
                $(function(){
                    FlipClock.Lang.Custom = { days:'Zile', hours:'Ore', minutes:'Minute', seconds:'Seconde' };
                    var opts = {
                        clockFace: 'DailyCounter',
                        countdown: true,
                        language: 'Custom'
                    };
                    var countdown = 1489561200 - ((new Date().getTime())/1000); // from: 03/15/2017 09:00 am +0200
                    countdown = Math.max(1, countdown);
                    $('.clock-builder-output').FlipClock(countdown, opts);
                });
            </script>
        </div>
        <div class="col-sm-1">
        </div>
    </div>
</div><br>

<div class="text-center" id="about-line">
    <div id="about-text">Despre noi</div>
    <div class="row">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-2">
            <img src="/images/db.jpg" class="img-responsive" style="width:100%" alt="Image">
            <p>Dan Bolohan<br/>
                Back-end Developer</p>
        </div>
        <div class="col-sm-2">
            <img src="/images/ad.jpg" class="img-responsive" style="width:100%" alt="Image">
            <p>Andrei Dinu<br/>
                Back-end Developer</p>
        </div>
        <div class="col-sm-2">
            <img src="/images/rd.jpg" class="img-responsive" style="width:100%" alt="Image">
            <p>Raluca Dobroiu<br/>
                Front-end Developer</p>
        </div>
        <div class="col-sm-2">
            <img src="/images/mn.jpg" class="img-responsive" style="width:100%" alt="Image">
            <p>Matei Neagu<br/>
                Front-end Developer</p>
        </div>
        <div class="col-sm-2">
        </div>
    </div>
</div><br>

<div id="contact-line">
    <div class="row">

        <div class="col-sm-4">
            <img src="/images/contact.png" class="img-responsive" style="width:100%" alt="Image">

        </div>
        <div class="col-sm-2" id="left-contact">

            <div id="contact-text-sec">Contact</div><br>
            <p id="contact-text-p">E-mail: contact@bookzilla.ro<br />
                Telefon: +40700112233<br /></p>
        </div>
        <div class="col-sm-4" id="right-contact">
            <div id="contact-text-sec">Trimite mesaj:</div><br>
            <div class="form-group">
                <label id="lbl-cmt" for="nume">Nume:</label>
                <input type="text" class="form-control" id="nume-cnt">
            </div>
            <div class="form-group">
                <label id="lbl-cmt" for="email">Email:</label>
                <input type="text" class="form-control" id="email-cnt">
            </div>
            <div class="form-group">
                <label id="lbl-cmt" for="coment-cnt">Comentariu:</label>
                <textarea class="form-control" rows="5" id="coment-cnt"></textarea>
            </div>
            <button type="button" class="btn btn-warning btn-lg" id="trimit-cmt">Trimite</button>
        </div>
        <div class="col-sm-2">
        </div>
    </div>
</div>

<footer class="container-fluid text-center" id="footer-landing">
    <p>&copy;BOOKZILLA</p>
</footer>

</body>
</html>

