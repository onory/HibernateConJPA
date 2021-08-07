<%-- 
    Pagina que se redirije despues de pasar por controlador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        
        <title>Listado Personas</title>
    </head>
    <body>
        
      
        <table border="1">
            
            <caption>Listado de Personas</caption>
            <tr>
                <th>Id Persona</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Email</th>
                <th>Telefono</th>
            </tr>
        <!-- este renglon se repetira tantas veces como registros se tenga, por ello se debera iterar -->    
            
        <c:forEach var="persona" items="${personas}">
            
            <!-- por medio de la variable personas compartida scope request en controlaro en podemos acceder a los atributos por EL -->
            <!-- la variable persona se utilizara para aceder -->
            <tr>
                <td>${persona.idPersona}</td>
                <td>${persona.nombre}</td>
                <td>${persona.apellido}</td>
                <td>${persona.email}</td>
                <td>${persona.telefono}</td>
            </tr>
            
            
        </c:forEach>
        
        </table>
        
    </body>
</html>
