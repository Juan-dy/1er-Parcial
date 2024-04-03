<%@page import="com.mycompany.primerparcial.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Persona reg = (Persona) request.getAttribute("objetoE");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h3>Primer Parcial TEM-742</h2
        <p>Nombre: Juan de Dios Mamani Mamani</p>
        <p>Carnet: </p>

        <h2>Registro de Calificaciones</h1>
        
        <form action="MainServlet" method="post">
            
            
                    <input type="hidden" name="id" value="<%= reg.getId() %>">
               
                    Nombre del estudiante: <input type="text" name="nombre" value="<%= reg.getNombre()  %>">
                    <br>
                    Primer parcial (sobre 30pts) <input type="text" name="par1" size="2" value="<%= reg.getP1() %>">
                    <br>
                    Segundo parcial (sobre 30pts) <input type="text" name="par2" size="2" value="<%= reg.getP2() %>">
                    <br>
                    Examen final (sobre 40pts) <input type="text" name="exaf" size="2" value="<%= reg.getEf() %>">
                    <br>
                    <input type="submit" value="ENVIAR">
        </form>
                
    </body>
</html>
