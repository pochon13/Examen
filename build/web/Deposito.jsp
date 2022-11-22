<%-- 
    Document   : Deposito
    Created on : 22/11/2022, 01:25:16 PM
    Author     : jorge.rodriguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="Deposito" method="POST" autocomplete="off">        
        <label>tarjeta</label>
        <input type="text" maxlength="16" id="tarjeta" name="tarjeta" required="">
        <label>Cantidad a depositar</label>
        <input type="text" maxlength="40" id="dep" name="dep" required="">        
        <input type="submit" value="Depositar">
        </form>
        
           <% String Mensaje = (String) request.getAttribute("error");
                   if (Mensaje != null) {%> 
                   <label><%=Mensaje%></label>
                   <%}%>
    </body>
</html>
