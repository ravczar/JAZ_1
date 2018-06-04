<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
    <head>
        <meta charset="UTF-8">
        <title>Harmonogram</title>
    </head>
    <body>
         <table table border="3" align="center">
         <tr>
         <th>Numer raty</th>
         <th>Kwota kapitału</th>
         <th>Kwota odsetek</th>
         <th>Opłata stała</th>
         <th>Całkowita kwota raty</th>
         </tr>
         <c:forEach items="${raty}" var="rata">
             <tr>
                 <td  align="center"><c:out value="${rata.numberOfInstallment}"/></td>
                 <td  align="center"><c:out value="${rata.amountOfCapital}"/></td>
                 <td  align="center"><c:out value="${rata.amountOfInterest}"/></td>
                 <td  align="center"><c:out value="${rata.fixedFeeAmount}"/></td>
                 <td  align="center"><c:out value="${rata.totalAmountOfInstallment}"/></td>
             </tr>
         </c:forEach>
         </table>
         <center>
         	<button onclick="window.location.href='/'">Powrót do formularza</button>
         </center>
    </body>
</html>