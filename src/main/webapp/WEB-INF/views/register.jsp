<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
    <title>AUTENTIFICARE</title>
    <style> <%@include file="../../resources/css/style.css" %> </style>
    <style> <%@include file="/resources/css/normalize.css" %> </style>
    <style> <%@include file="/resources/css/font-awesome.min.css" %> </style>
    <style> <%@include file="/resources/css/set2.css" %> </style>

</head>
<body>
<div id="frame">
    <center>
        <img src="/images/logo.png" style="width:150px;height:150px;float:left;margin-top:5%;margin-bottom:5%; margin-left:37.5%;"/>
    </center>
    <hr/>
    <div id="content">
        <div id="greetings">
            <label id="welcome">Bine ai venit la <b>Bookzilla</b>!</label>
        </div>

        <hr/>

        <form name='loginForm'
              action="<c:url value='/register' />" method='POST'>

            <div id="fields">

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="lastName" name="lastName"/>
					<label class="input__label input__label--nao" for="lastName">
						<span class="input__label-content input__label-content--nao">Nume</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="firstName" name="firstName"/>
					<label class="input__label input__label--nao" for="firstName">
						<span class="input__label-content input__label-content--nao">Prenume</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="username" name="username"/>
					<label class="input__label input__label--nao" for="username">
						<span class="input__label-content input__label-content--nao">User</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="telefon" name="telefon"/>
					<label class="input__label input__label--nao" for="telefon">
						<span class="input__label-content input__label-content--nao">Telefon</span>
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

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="password" id="passwordConf" name="passwordConf"/>
					<label class="input__label input__label--nao" for="passwordConf">
						<span class="input__label-content input__label-content--nao">Confirma Parola</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="emailAddress" name="emailAddress"/>
					<label class="input__label input__label--nao" for="emailAddress">
						<span class="input__label-content input__label-content--nao">E-mail</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

            </div>
            <div id="submit">
                <button type="submit" class="buttonLogIn" id="butonSubmit">Creaza cont</button>
            </div>
        </form>
    </div>
    <br/>
</div>
<br/>
</body>
<footer>
</footer>
</html>
