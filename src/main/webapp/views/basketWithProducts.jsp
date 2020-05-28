<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: boulat
  Date: 16.05.2020
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Корзина</title>
</head>
<body>
<jsp:include page="headers/index_header.jsp"/><div style="width: 100%; height: 800px; vertical-align: bottom">
    <div align="center" style="line-height: 100px; background-color: gray">

            <h2 text-align: center;>Корзина</h2>
            <label  text-align: center; > Вы выбрали: </label>
            <table width = "100%" border = "1" align = "center">
                <tr bgcolor = "#949494">
                    <th>productsName</th>
                    <th>value</th>
                </tr>
                <%
                    Enumeration paramNames = request.getParameterNames();
                    while(paramNames.hasMoreElements()) {
                        String paramName = (String)paramNames.nextElement();
                        out.print("<tr><td>" + paramName + "</td>\n");
                        String paramValue = request.getHeader(paramName);
                        out.println("<td> " + paramValue + "</td></tr>\n");
                    }
                %>
            </table>


    </div>
</div>
</body>
</html>
