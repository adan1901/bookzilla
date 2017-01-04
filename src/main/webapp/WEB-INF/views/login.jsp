<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@page session="true"%>

<html>
<head>
    <title>LOG IN</title>
    <style> <%@include file="/resources/css/style.css" %> </style>
    <style> <%@include file="/resources/css/normalize.css" %> </style>
    <style> <%@include file="/resources/css/font-awesome.min.css" %> </style>
    <style> <%@include file="/resources/css/set2.css" %> </style>


</head>
<body onload='document.loginForm.username.focus();'>
    <div id="frame">
         <center>
            <img src="/images/logo.png" style="width:150px;height:150px;float:left;margin-top:5%;margin-bottom:5%; margin-left:37.5%;"/>
         </center>
        <hr/>
        <div id="content">
            <div id="greetings">
                <h1>Bine ai revenit la <b>Bookzilla</b>!</h1>
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

                        <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="username" name="username"/>
					<label class="input__label input__label--nao" for="username">
						<span class="input__label-content input__label-content--nao">Username</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>
                        <br/>
                        <span class="input input--nao">
					<input class="input__field input__field--nao" type="password" id="password" name="password"/>
					<label class="input__label input__label--nao" for="password">
						<span class="input__label-content input__label-content--nao">Parola</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                    </div>
                <div id="submit">
                    <button type="submit" class="buttonLogIn" id="butonSubmit">Intra in cont</button>
                </div>
            </form>
        </div>
        <br/>
    </div>
<br/>
<center>
    <a href="<c:url value="/register"/>">Nu ai cont? Inregistreaza-te acum!</a>
</center>
</body>
<footer>
</footer>
</html>
