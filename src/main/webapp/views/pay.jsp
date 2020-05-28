<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>

<body>
    <div align="center" style="width: 100%; height: 160px; background-color: #5a5a5a">
        <form style="width: 100%; height: 100%" id="payForm" action="/pay" method="post">
            <table style="height: 100%">
                <tr>
                    <td><label>Целевой счет</label></td>
                    <td><input type="number" name="payTargetCount"></td>
                </tr>
                <tr>
                    <td><label>Сумма</label></td>
                    <td><input type="number" name="paySum"></td>
                </tr>
                <tr>
                    <td colspan="2"><input style="width: 100%" type="submit" value="Оплатить"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>