<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true"%>

<html>
<head>
    <title>LOG IN</title>
    <style> <%@include file="/resources/css/style.css" %> </style>

</head>
<body onload='document.loginForm.username.focus();'>
<div id="logo">
    <img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/>
</div>
<div id="titluLogIn">
    <label id="autentificare">
        <br/>
        LOG IN
    </label>
</div>

<hr/>

<form name='loginForm'
    action="<c:url value='/login' />" method='POST'>

    <div id="fields">

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <div id="inputs">

            <label id="user" style="float:left; font-size:20px">User</label>
            <input id="username" type="text" name="username"/>
            <br/><br/>

            <label id="parola" style="float:left; font-size:20px">Parola</label>
            <input id="password" type="password" name="password"/>
            <br/><br/>
        </div>
    </div>
    <div id="submit">
        <button type="submit" id="butonSubmit">Log In</button>
    </div>
</form>
<br/>
<center>
    <a href="<c:url value="/register"/>">Nu ai cont? Inregistreaza-te acum!</a>
</center>
</body>
<footer>
</footer>
</html>
