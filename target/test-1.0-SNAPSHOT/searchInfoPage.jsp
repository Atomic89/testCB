<%--
  Created by IntelliJ IDEA.
  User: NikolaevSA
  Date: 08.12.2018
  Time: 15:19
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Поиск</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/search" method="post">
    <p>Введите Инн
        <input type="text" name="inn" pattern="[0-9]{10,12}" maxlength="12" title="Разрешены только цифры и длина 10-12" /></p>

    <p>Введите ОГРН
        <input type="text" name="ogrn" pattern="[0-9]{13}" maxlength="13" title="Разрешены только цифры и длина 13"/></p>

    <p>Введите Имя организации
        <input type="text" name="name"/></p>

    <p>Введите Адрес
        <input type="text" name="address" /></p>

    <input type="submit" name="submit" value="Отправить" />
    <button type="submit" name="all" value="igm">Вывести все</button>
</form>
<p><a href="/add">Добавление записи</a></p>
    <table>

        <tr>
            <td>ИНН</td>
            <td>ОГРН</td>
            <td>Имя организации</td>
            <td>Адрес</td>
        </tr>

        <c:forEach var="List" items="${records}">
            <tr>
            <td>${List.inn}</td>
            <td>${List.ogrn}</td>
            <td>${List.name}</td>
            <td>${List.address}</td>
            </tr>
        </c:forEach>

    </table>

</body>
</html>
