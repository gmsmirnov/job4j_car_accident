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
    <h2>Зарегистрируйте новое происшествие:</h2>
    <form method="post" action="<c:url value="/add_accident.do"/>">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="validationServer03">Тип происшествия</label>
                <input type="text" class="form-control" id="validationServer03" placeholder="Тип происшествия" name="name" required>
            </div>
            <div class="col-md-12 mb-3">
                <label for="validationServer01">Описание</label>
                <input type="text" class="form-control" id="validationServer01" placeholder="Описание происшествия" name="text" required>
            </div>
            <div class="col-md-12 mb-3">
                <label for="validationServer02">Адрес</label>
                <input type="text" class="form-control" id="validationServer02" placeholder="Адрес" name="address" required>
            </div>

        </div>
        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
</div>
</body>
</html>