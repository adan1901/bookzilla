<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <title>AUTENTIFICARE</title>
    <style> <%@include file="styles/style.css" %> </style>

</head>
<body>
<div id="logo">
    <img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/>
</div>
<div id="titluAutentificare">
    <label id="autentificare">
        <br/>
        AUTENTIFICARE
    </label>
</div>
<hr/>
<form name='loginForm'
      action="<c:url value='/register' />" method='POST'>
    <div id="fields">
        <div id="inputs">
            <label id="nume" style="float:left; font-size:20px">Nume</label>
            <input id="lastName" type="text" name="lastName"/>
            <br/><br/>

            <label id="prenume" style="float:left; font-size:20px">Prenume</label>
            <input id="firstName" type="text" name="firstName"/>
            <br/><br/>

            <label id="user" style="float:left; font-size:20px">User</label>
            <input id="username" type="text" name="username"/>
            <br/><br/>

            <label id="tel" style="float:left; font-size:20px">Telefon</label>
            <input id="telefon" type="text" name="telefon">
            <br/><br/>

            <label id="parola" style="float:left; font-size:20px">Parola</label>
            <input id="password" type="password" name="password"/>
            <br/><br/>

            <label id="condParola" style="float:left; font-size:20px">Confirma Parola</label>
            <input id="passwordConf" type="password" name="passwordConf"/>
            <br/><br/>

            <label id="email" style="float:left; font-size:20px">E-mail</label>
            <input id="emailAddress" type="text" name="emailAddress"/>
            <br/><br/>
        </div>
    </div>
    <div id="submit">
        <button type="submit" id="butonSubmit">Confirma</button>
        </div>
</form>

</div>
</body>
<footer>
</footer>
</html>
