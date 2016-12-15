<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>

    <style> <%@include file="/resources/css/styles.css" %> </style>

</head>
<body>
<div id="headdiv">
    <div id="logo">
        <img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/>
    </div>
    <br />
    <div id="labelUser">

        <label id="user" onclick="location.href='/user-details';">${name}</label>

        <input type="button" id="logout" onclick="location.href='/logout';" value="Log Out" />

    </div>

    <center><label id="titluPagina">BOOKZILLA</label></center>
</div>
<hr/>
<div id="centerdiv">
    <div id="leftcol">
        <div id="categorii">
            <br />
            <center><label id="titluCategorii">CATEGORII</label></center>
            <ul>
                <li>
                    <a href="#">Arta si fotografie</a>
                </li>
                <li>
                    <a href="#">Beletristica</a>
                </li>
                <li>
                    <a href="#">Critica</a>
                </li>
                <li>
                    <a href="#">Biografii</a>
                </li>
                <li>
                    <a href="#">Memorialistica</a>
                </li>
                <li>
                    <a href="#">IT</a>
                </li>
                <li>
                    <a href="#">Copii</a>
                </li>
                <li>
                    <a href="#">Enciclopedie</a>
                </li>
                <li>
                    <a href="#">Filozofie</a>
                </li>
                <li>
                    <a href="#">Istorie</a>
                </li>
            </ul>
        </div>
        <br />
        <div id="limba">
            <br />
            <center><label id="titluCategorii">LIMBA</label></center>
            <ul>
                <li>
                    <a href="#">Romana</a>
                </li>
                <li>
                    <a href="#">Engleza</a>
                </li>
                <li>
                    <a href="#">Germana</a>
                </li>
                <li>
                    <a href="#">Franceza</a>
                </li>
                <li>
                    <a href="#">Spaniola</a>
                </li>
                <li>
                    <a href="#">Ungara</a>
                </li>
                <li>
                    <a href="#">Alte limbi</a>
                </li>

            </ul>
        </div>
    </div>
    <div id="middlecol">
        <div id="search">
            <form>
                <input type="text" placeholder="Search..." required id="searchbar">
                <input type="button" value="Search" id="searchButton">
            </form>
        </div>
        <div id="recomandari">
            <label id="titluRecomandari">RECOMANDARI</label>
            <br />
            <div id="recLeft">
                <center>
                    <%--<a href="<c:url value="/book-details/1"/>">--%>
                        <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
                    <%--</a>--%>
                </center>
            </div>
            <div id="recMid">
                <center>
                    <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
                </center>
            </div>
            <div id="recRight">
                <center>
                    <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
                </center>
            </div>
            <br />
            <div id="recLeft">
                <center>
                    <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
                </center>
            </div>
            <div id="recMid">
                <center>
                    <img src="http://t2.gstatic.com/images?q=tbn:ANd9GcSVT0-lKGM7s7ZbVv8iQb0J2VogGEBefu1uyduxA-Awc6I9ANKQ" id="recImg"/>
                </center>
            </div>
            <div id="recRight">
                <center>
                    <a href="<c:url value="/book-details/6"/>">
                        <img src="https://s-media-cache-ak0.pinimg.com/236x/15/bd/d0/15bdd0091b241028f44bbbe3ce5f9d58.jpg" id="recImg"/>
                    </a>
                </center>
            </div>
        </div>
    </div>
    <div id="rightcol">
        <div id="judete">
            <br />
            <center><label id="titluCategorii">JUDETE</label></center>
            <ul>
                <li>
                    <a href="#">Alba</a>
                </li>
                <li>
                    <a href="#">Arad</a>
                </li>
                <li>
                    <a href="#">Arges</a>
                </li>
                <li>
                    <a href="#">Bacau</a>
                </li>
                <li>
                    <a href="#">Bihor</a>
                </li>
                <li>
                    <a href="#">Bistrita-Nasaud</a>
                </li>
                <li>
                    <a href="#">Botosani</a>
                </li>
                <li>
                    <a href="#">Brasov</a>
                </li>
                <li>
                    <a href="#">Braila</a>
                </li>
                <li>
                    <a href="#">Bucuresti</a>
                </li>

            </ul>
        </div>
        <br />
        <div id="distanta">
            <br />
            <center><label id="titluCategorii">Distanta</label></center>
            <p>To be implemented..</p>
        </div>
    </div>
</div>
</body>
</html>
