<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Успешная регистрация</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/><div style="width: 100%; line-height: 800px; vertical-align: bottom">
    <div align="center" style="background-color: gray">

        <form id="clientSuccessRegistrationForm" action="selectProducts.jsp" method="post">
            <label>Пользователь </label>
            <output>"${sessionScope.firstname}"</output>
            <label> успешно зарегистрирован!</label>
            <br>
            <input type="submit" name="enterSystem" value="Перейти в систему" />
        </form>
    </div>
</div>
</body>
</html>