<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <style> <%@include file="../../resources/css/styles.css" %> </style>

</head>
<body>
<div id="logo">
    <a href="index.html"><img src="img/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/></a>
</div>
<div id="labelUser">
    <label id="user">Nume Prenume</label>
    <button type="button" id="logout">Log Out</button>
</div>
<div id="titluProfil">

    <br /><br />
    <label id="titluPagina">PROFIL</label>
</div>
<hr/>
<div id="lftCol">
    <img id="profilImg" src="https://i.ytimg.com/vi/8p4ZjrDkX6g/maxresdefault.jpg" style="width:240px;height:360px" />
</div>
<div id="rghtCol">
    <div id="colTop">
        Nume: <label id="nume">Mr.</label>
        <br />
        Prenume: <label id="prenume">Cattington</label>
        <br />
        Telefon: <label id="telefon">0789898989</label>
        <br />
    </div>
    <br />
    <div id="colMid">
        <label id="titluBiblioteca">BIBLIOTECA PERSONALA</label>
        <br />
        <a href="#">
            <img src="https://ae01.alicdn.com/kf/HTB12T9XKVXXXXcGaXXXq6xXFXXXU/New-Needlework-font-b-Glasses-b-font-font-b-Cat-b-font-Lying-On-The-Sofa.jpg" style="margin-left:10px;width:180px;height:200px;float:left;margin-top:10px;" />
        </a>
        <a href="#">
            <img src="https://ae01.alicdn.com/kf/HTB12T9XKVXXXXcGaXXXq6xXFXXXU/New-Needlework-font-b-Glasses-b-font-font-b-Cat-b-font-Lying-On-The-Sofa.jpg" style="width:180px;height:200px;float:right;margin-top:10px;" />
        </a>
        <a href="adaugare_carte.html"><button type="button" id="addBook">Adauga o carte</button></a>
    </div>

</div>
</body>
</html>
