<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page session="true"%>
<html>
<head>
    <title>ADAUGA CARTE</title>
    <style> <%@include file="../../resources/css/style.css" %> </style>

</head>
<body>
<div id="logo">
    <a href="<c:url value="/"/>"><img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/></a>
</div>
<div id="titluAdaugaCarte">
    <label id="autentificare">
        <br/>
        ADAUGA CARTE
    </label>
</div>
<hr/>
<form name='addBookForm'
      action="<c:url value='/add-book' />" method='POST'>
    <div id="fields">
        <div id="inputs">
            <label id="titlu" style="float:left; font-size:20px">TITLU:</label>
            <input id="titluCarte" type="text" name="bookTitle"/>
            <br/><br/>

            <label id="url" style="float:left; font-size:20px">URL COPERTA:</label>
            <input id="urlCoperta" type="text" name="bookCoverUrl"/>
            <br/><br/>

            <label id="autor" style="float:left; font-size:20px">AUTOR:</label>
            <input id="autorCarte" type="text" name="bookAuthor"/>
            <br/><br/>

            <label id="editura" style="float:left; font-size:20px">EDITURA:</label>
            <input id="edituraCarte" type="text" name="bookPublisher"/>
            <br/><br/>

            <label id="limba" style="float:left; font-size:20px">LIMBA:</label>
            <input id="limbaCarte" type="text" name="bookLanguage"/>
            <br/><br/>

            <label id="categorii" style="float:left; font-size:20px">CATEGORII<br />(separate prin virgula):</label>
            <input id="categoriiCarte" type="text" name="bookCateg"/>
            <br/><br/>

            <br/><br/>
        </div>
    </div>
    <div id="submit">
        <button type="submit" id="butonAddCarte">Adauga cartea!</button>
    </div>
</form>

</div>
</body>
<footer>
</footer>
</html>

