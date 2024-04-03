<%@page import="java.util.ArrayList"%>
<%@page import="com.mycompany.primerparcial.Persona"%>
<%
    if(session.getAttribute("lP") == null){
        ArrayList<Persona> lAux = new ArrayList<Persona>();
        
        session.setAttribute("lP", lAux);
    }
    ArrayList<Persona> lista = (ArrayList<Persona>) session.getAttribute("lP");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <h3>Primer Parcial TEM-742</h2
        <p>Nombre: Juan de Dios Mamani Mamani</p>
        <p>Carnet: 9968105</p>

        <h2>Registro de Calificaciones</h1>
        
        <a href="MainServlet?op=nuev">Nuevo</a>
        
        <table border="2px">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>Nota</th>
            </tr>
            
            <%
                if(lista != null){
                    for(Persona el: lista){
                    int n = el.getP1()+el.getP2()+el.getEf();
                    
            %>
            
            <tr>
                <td> <%= el.getId() %> </td>
                <td> <%= el.getNombre() %></td>
                <td> <%= el.getP1() %> </td>
                <td> <%= el.getP2() %> </td>
                <td> <%= el.getEf() %> </td>
                
                <td> <%= n  %> </td>
                
                <td> <a href="MainServlet?op=mod&id=<%= el.getId() %>">Editar</a> </td>
                <td> <a href="MainServlet?op=el&id=<%= el.getId() %>">Eliminar</a> </td>
                
                
            </tr>
            
            <%
                    }
                }
            %>
            
        </table>
    </body>
</html>
