<%-- 
    Document   : index
    Created on : 22/11/2022, 01:50:10 PM
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
          <form action="Alta" method="POST" autocomplete="off">        
        <label>Alta de tarjeta</label>
        <input type="text" maxlength="16" id="tarjeta" name="tarjeta" required="">
        <label>Nombre</label>
        <input type="text" maxlength="40" id="nombre" name="nombre" required="">        
        <input type="submit" value="Dar de alta">
        </form>
        
           <% String Mensaje = (String) request.getAttribute("error");
                   if (Mensaje != null) {%> 
                   <label><%=Mensaje%></label>
                   <%}%>
    </body>
</html>
