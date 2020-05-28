<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница аутентификации</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/>
<div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
    <form style="width: 100%; height: 100%" id="clientAuthForm" action="${pageContext.servletContext.contextPath}/auth" method="post">
        <table style="height: 100%">
            <tr>
                <td>
                    <label>Логин</label>
                </td>
                <td>
                    <input id="authLogin" type="text" name="login">
                </td>
            </tr>
            <tr>
                <td>
                    <label>Пароль</label>
                </td>
                <td>
                    <input type="password" name="psswd">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input id="authEnterButton" style="width: 100%" type="submit" value="Войти">
                </td>
            </tr>
        </table>
    </form>
</div>
</div>
</body>
</html>