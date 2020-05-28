<%--
  Created by IntelliJ IDEA.
  User: boulat
  Date: 01.05.2020
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

        <style>
            body {background-color: antiquewhite;}
            h1   {color: darkolivegreen;}
            input    {color: darkolivegreen;}
        </style>
    </head>

<body>
<jsp:include page="headers/system_header.jsp"/>
<h2>Я хочу застраховать </h2>

    <label  text-align: center; > Выберите продукт страхования:</label>
    <div style="width: 100%; height: 800px;  display: flex; justify-content: center; align-items: center; background-color: gray">
        <div align="center" style="width: 100%; height: 160px; background-color: antiquewhite">
            <form action="${pageContext.servletContext.contextPath}/selectProducts"  method="post" >

                <table align="center" style="height: 100%; width: 100%; border-spacing: 10px">
                    <tr>
                        <td width="50%" align="right">
                            <input type="checkbox" name="productNam" value="lifeInsurance" style="width: 200px; height: 50px; font-size: large"/>Страхование жизни<br>


                        </td></tr>
                    <tr><td width="50%">
                            <input type="checkbox" name="productNam" value="carInsurance" style="width: 200px; height: 50px; font-size: large"/>Страхование автомобиля<br>
                        </td></tr>
                    <tr><td width="50%" align="right">
                            <input type="checkbox" name="productName" value="houseInsurance" style="width: 200px; height: 50px; font-size: large"/>Страхование недвижимости  <br>
                        </td></tr>
                    <tr> <td width="50%" align="right">
                            <input type="checkbox" name="productName" value="" style="width: 200px; height: 50px; font-size: large"/>Страхование здоровья велосипедиста<br>
                        </td></tr>
                    <tr><td width="50%" align="right">
                            <input type="checkbox" name="productName" value="cyclistLifeInsurance" style="width: 200px; height: 50px; font-size: large"/>Страхование здоровья велосипедиста<br>
                        </td></tr>
                    </tr>
                </table>
                <input type = "submit" name="selectSubject" value="Выбрать и  перейти в корзину" />
                <input type="submit" name="Choose" value="выб"/>
            </form>
        </div>
















</body>
</html>
