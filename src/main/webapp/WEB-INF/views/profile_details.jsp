<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <style> <%@include file="/resources/css/styles.css" %> </style>

</head>
<body>
<div id="logo">
    <a href="<c:url value="/"/>"><img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/></a>
</div>
<div id="labelUser">
    <%--<label id="user">${name}</label>--%>
    <input type="button" id="logout" onclick="location.href='/logout';" value="Log Out" />
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
        Nume: <label id="nume">${lastName}</label>
        <br />
        Prenume: <label id="prenume">${firstName}</label>
        <br />
        Telefon: <label id="telefon">0789898989</label>
        <br />
    </div>
    <br />
    <div id="colMid">
        <label id="titluBiblioteca">BIBLIOTECA PERSONALA</label>
        <br />
        <c:forEach items="${bookCollection}" var="book">
            <a href="/book-details/${book.id}">
                <img src="${book.urlLocation}" style="margin-left:10px;width:180px;height:200px;float:left;margin-top:10px;" />
            </a>
        </c:forEach>

        <c:if test="${userIsPriviliged}">
            <a href="<c:url value="/add-book"/>"><button type="button" id="addBook">Adauga o carte</button></a>
        </c:if>
    </div>

</div>
</body>
</html>
