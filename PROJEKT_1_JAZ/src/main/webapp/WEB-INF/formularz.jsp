<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl-PL">
       <head>
        <title>Formularz</title>
        <h2>Formularz kredytowy</h2>
    </head>
    <body>
         <form method="POST" action="/harmonogram" >
         <table>
         <tr>
            <td>Wnioskowana kwota kredytu</td>
            <td><input type="number" name="kwotaKredytu"  required="required"  min="1000" max="999999999" /></td>
            </tr>
            <tr>
            <td>Ilość rat</td>
            <td><input type="number" name="iloscRat"  required="required"  min="2" max "360"/></td>
            </tr>
            
            <td>Oprocentowanie</td>
            <td><input type="number" name="oprocentowanie"  required="required" min="1" max "100"/></td>
            <tr>
            <td>Oplata stala</td>
            <td><input type="number" name="oplataStala"  required="required" min ="0" max="1000"/></td>
            </tr>
            
            <tr>
            <td>Typ raty</td>
            <td><select name="typRaty">
                <option value="STALA" >Stała</option>
                <option value="MALEJACA">Malejąca</option>
            </select></td>
            </tr>
            
            <tr>
            <td>&nbsp</td>
            </tr>
           
            <tr>
            <td></td>
            <td>
                <input type="submit" formaction="/harmonogram?rodzajRaportu=HTML" value="Wygeneruj HTML" />
                <input type="submit" formaction="/harmonogram?rodzajRaportu=PDF" value="Wygeneruj PDF" />
            </td>
            </tr>
            
            </table>
         </form>
    </body>
</html>