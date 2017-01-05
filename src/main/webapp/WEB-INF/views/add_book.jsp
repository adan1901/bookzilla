<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true"%>
<html>
<head>
    <title>ADAUGA CARTE</title>
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

        <form name='addBookForm'
              action="<c:url value='/add-book' />" method='POST'>

            <div id="fields">

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="titluCarte" name="bookTitle"/>
					<label class="input__label input__label--nao" for="titluCarte">
						<span class="input__label-content input__label-content--nao">Titlu</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="urlCoperta" name="bookCoverUrl"/>
					<label class="input__label input__label--nao" for="urlCoperta">
						<span class="input__label-content input__label-content--nao">URL Coperta</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="autorCarte" name="bookAuthor"/>
					<label class="input__label input__label--nao" for="autorCarte">
						<span class="input__label-content input__label-content--nao">Autor</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="edituraCarte" name="bookPublisher"/>
					<label class="input__label input__label--nao" for="edituraCarte">
						<span class="input__label-content input__label-content--nao">Editura</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="limbaCarte" name="bookLanguage"/>
					<label class="input__label input__label--nao" for="limbaCarte">
						<span class="input__label-content input__label-content--nao">Limba</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>

                <span class="input input--nao">
					<input class="input__field input__field--nao" type="text" id="categoriiCarte" name="bookCateg"/>
					<label class="input__label input__label--nao" for="categoriiCarte">
						<span class="input__label-content input__label-content--nao">Categorii(separate prin virgula)</span>
					</label>
					<svg class="graphic graphic--nao" width="300%" height="100%" viewBox="0 0 1200 60" preserveAspectRatio="none">
						<path d="M0,56.5c0,0,298.666,0,399.333,0C448.336,56.5,513.994,46,597,46c77.327,0,135,10.5,200.999,10.5c95.996,0,402.001,0,402.001,0"/>
					</svg>
				</span>

                <br/>


            </div>
            <div id="submit">
                <button type="submit" class="buttonLogIn" id="butonAddCarte">Adauga cartea!</button>
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
