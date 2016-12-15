<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <!--script src="main.js"></script-->
    <title>BOOKZILLA</title>
    <style> <%@include file="../../resources/css/styles.css" %> </style>

</head>
<body>

<div id="logo">
    <a href="<c:url value="/"/>"><img src="/images/logo.png" style="width:50px;height:50px;float:left;margin-left:15%;margin-top:50px;"/></a>
</div>
<div id="labelUser">
    <label id="user">${firstName} ${lastName}</label>
    <input type="button" id="logout" onclick="location.href='/logout';" value="Log Out" />
</div>
<div id="titluCarte">
    <br /><br />
    <label id="numeCarte">NUME CARTE</label>
</div>
<hr/>
<div id="lftCol">
    <img id="profilImg" src="<c:url value="${bookImgUrl}" />" style="width:240px;height:360px" />
</div>
<div id="rghtCol">
    <div id="colTop">
        Titlu: <label id="nume">${bookTitle}</label>
        <br />
        Autor: <label id="prenume">${bookAuthor}</label>
        <br />
        Editura: <label id="telefon">${bookPublisher}</label>
        <br />
        Categorie: <label id="telefon">${bookCategory}</label>
        <br />
    </div>
    <br />
    <div id="colMid">
        <label id="titluBiblioteca">Cine are aceasta carte?</label>
        <br />
        <c:forEach items="${usersHavingTheBook}" var="userWithBook">
            <a href="/user-details/show-profile?username=${userWithBook.username}">
                ${userWithBook.firstName} ${userWithBook.lastName}
            </a>
            <br/>
        </c:forEach>
    </div>

</div>
</body>
</html>
