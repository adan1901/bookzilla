<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <form:form method="POST" modelAttribute="userForm" name='loginForm'>

            <div id="fields">

				<spring:bind path="lastName">
					<div class="form-group ${status.error ? 'has-error' : ''}">
						<span class="input input--nao">
							<form:input class="input__field input__field--nao" type="text" id="lastName" path="lastName"></form:input>
                            <form:errors path="lastName"></form:errors>
							<label class="input__label input__label--nao" for="lastName">
								<span class="input__label-content input__label-content--nao">Nume</span>
							</label>

							<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
								<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
							</svg>
						</span>
					</div>
				</spring:bind>

                <br/>

                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <span class="input input--nao">
                            <form:input class="input__field input__field--nao" type="text" id="firstName" path="firstName"></form:input>
                            <form:errors path="firstName"></form:errors>
                            <label class="input__label input__label--nao" for="firstName">
                                <span class="input__label-content input__label-content--nao">Prenume</span>
                            </label>
                            <svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
                                <path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
                            </svg>
                        </span>
                    </div>
                </spring:bind>

                <br/>

                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <span class="input input--nao">
                            <form:input class="input__field input__field--nao" type="text" id="username" path="username"></form:input>
                            <form:errors path="username"></form:errors>
                            <label class="input__label input__label--nao" for="username">
                                <span class="input__label-content input__label-content--nao">User</span>
                            </label>
                            <svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
                                <path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
                            </svg>
                        </span>
                    </div>
                </spring:bind>

                <%--<br/>--%>

                <%--<span class="input input--nao">--%>
					<%--<input class="input__field input__field--nao" type="text" id="telefon" name="telefon"/>--%>
					<%--<label class="input__label input__label--nao" for="telefon">--%>
						<%--<span class="input__label-content input__label-content--nao">Telefon</span>--%>
					<%--</label>--%>
					<%--<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">--%>
						<%--<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>--%>
					<%--</svg>--%>
				<%--</span>--%>

                <br/>

                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <span class="input input--nao">
                            <form:input class="input__field input__field--nao" type="password" id="password" path="password"></form:input>
                            <form:errors path="password"></form:errors>
                            <label class="input__label input__label--nao" for="password">
                                <span class="input__label-content input__label-content--nao">Parola</span>
                            </label>
                            <svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
                                <path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
                            </svg>
                        </span>
                    </div>
                </spring:bind>

                <br/>

                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <span class="input input--nao">
                            <form:input class="input__field input__field--nao" type="password" id="passwordConfirm" path="passwordConfirm"></form:input>
                            <form:errors path="passwordConfirm"></form:errors>
                            <label class="input__label input__label--nao" for="passwordConfirm">
                                <span class="input__label-content input__label-content--nao">Confirma Parola</span>
                            </label>
                            <svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
                                <path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
                            </svg>
                        </span>

                    </div>
                </spring:bind>

                <br/>

                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <span class="input input--nao">
                            <form:input class="input__field input__field--nao" type="text" id="email" path="email"></form:input>
                            <form:errors path="email"></form:errors>
                            <label class="input__label input__label--nao" for="email">
                                <span class="input__label-content input__label-content--nao">E-mail</span>
                            </label>
                            <svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
                                <path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
                            </svg>
                        </span>
                    </div>
                </spring:bind>

            </div>
            <div id="submit">
                <button type="submit" class="buttonLogIn" id="butonSubmit">Creaza cont</button>
            </div>
        </form:form>
    </div>
    <br/>
</div>
<br/>
</body>
<footer>
</footer>
</html>
