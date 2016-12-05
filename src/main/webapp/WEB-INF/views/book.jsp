<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <style> <%@include file="styles/styles.css" %> </style>

</head>
<body>

<div id="logo">
    <a href="<c:url value="/"/>"><img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/></a>
</div>
<div id="labelUser">
    <label id="user">${name}</label>
    <input type="button" id="logout" onclick="location.href='/logout';" value="Log Out" />
</div>
<div id="titluCarte">
    <br /><br />
    <label id="numeCarte">NUME CARTE</label>
</div>
<hr/>
<div id="lftCol">
    <img id="profilImg" src="https://s-media-cache-ak0.pinimg.com/236x/15/bd/d0/15bdd0091b241028f44bbbe3ce5f9d58.jpg" style="width:240px;height:360px" />
</div>
<div id="rghtCol">
    <div id="colTop">
        Titlu: <label id="nume">Training your cat...</label>
        <br />
        Autor: <label id="prenume">Ethel Evans</label>
        <br />
        Editura: <label id="telefon">RA</label>
        <br />
        Categorie: <label id="telefon">SCI-FI</label>
        <br />
    </div>
    <br />
    <div id="colMid">
        <label id="titluBiblioteca">Cine are aceasta carte?</label>
        <br />
        <a href="#">
            X-ulecu Jr
        </a>
        <br />
        <a href="#">
            X-ulescu Ionescu
        </a>
    </div>

</div>
</body>
</html>
