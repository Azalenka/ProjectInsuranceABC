<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<table width="100%">
    <tr>
        <td width="30%" align="left"><img src="${pageContext.servletContext.contextPath}/pics/logo.png" width="75"/></td>
        <td width="40%" align="center"><h1>Личный кабинет</h1></td>
        <td width="30%" align="right">
            <form id="profileForm" action="enterSystem.jsp" method="post">
                <input id="profileButton" type="submit" name="profileButton" value="В систему" style="width: 200px; height: 50px; font-size: medium"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>