<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Профиль</title>
</head>
<body>
<jsp:include page="headers/profile_header.jsp"/>
<div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
        <form style="width: 100%; height: 100%" id="clientAuthForm" action="${pageContext.servletContext.contextPath}/auth" method="post">
            <table style="height: 100%">
                <tr>
                    <td>Логин</td>
                    <td>"${sessionScope.login}"</td>
                </tr>
                <tr>
                    <td>Имя</td>
                    <td>"${sessionScope.firstname}"</td>
                </tr>
                <tr>
                    <td>Отчество</td>
                    <td>"${sessionScope.secondname}"</td>
                </tr>
                <tr>
                    <td>Фамилия</td>
                    <td>"${sessionScope.surname}"</td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>