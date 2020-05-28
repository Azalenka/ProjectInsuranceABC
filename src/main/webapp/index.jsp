<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Страница входа</title>
</head>
<body style="background-color:antiquewhite;">
<jsp:include page="views/headers/index_header.jsp"/>
<div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
        <form style="width: 100%; height: 100%" id="clientIdentForm" action="index" method="post">
            <table align="center" style="height: 100%; width: 100%; border-spacing: 10px">
                <tr>
                    <td width="50%" align="right">
                        <input type="submit" name="enter" value="Войти" style="width: 200px; height: 50px; font-size: large"/>
                    </td>
                    <td width="50%">
                        <input type="submit" name="reg" value="Зарегистрироваться" style="width: 200px; height: 50px; font-size: large"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>