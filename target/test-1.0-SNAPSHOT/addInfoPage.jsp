<%--
  Created by IntelliJ IDEA.
  User: NikolaevSA
  Date: 08.12.2018
  Time: 14:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление записи</title>
</head>
<body>
<h1>Добавление записи</h1>
<form action="${pageContext.request.contextPath}/add" method="post">
    <p>Введите Инн
        <input type="text" name="inn" pattern="[0-9]{10,12}" maxlength="12" required title="Разрешены только цифры и длина 10-12" /></p>

    <p>Введите ОГРН
        <input type="text" name="ogrn" pattern="[0-9]{13}" maxlength="13"  required title="Разрешены только цифры и длина 13" /></p>

    <p>Введите Имя организации
        <input type="text" name="name" required /></p>

    <p>Введите Адрес
        <input type="text" name="address" required /></p>

    <input type="submit" name="submit" value="Отправить" />
    <label>${success}</label>
    <p><a href="/search">Поиск записей</a></p>
</form>
</body>
</html>