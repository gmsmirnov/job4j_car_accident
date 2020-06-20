<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать в систему учета происшествий!</title>
</head>
<body>
<div class="container">
    <div>
        <p class="font-weight-bold">Имя пользователя: <c:out value="${user.username}"/>.</p>
    </div>
    <h2>Список происшествий:</h2>
    <table class="table table-striped" id="table">
        <tr>
            <th>ID:</th>
            <th>Тип происшествия:</th>
            <th>Описание:</th>
            <th>Адрес:</th>
        </tr>
        <c:forEach items="${index}" var="item">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.text}"/></td>
                <td><c:out value="${item.address}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a href="<c:url value="/add_accident.do"/>" class="btn btn-primary" role="button" aria-pressed="true">Добавить происшествие</a>
    <a href="<c:url value="/logout.do"/>" class="btn btn-primary" role="button" aria-pressed="true">Выйти из системы</a>
</div>
</body>
</html>