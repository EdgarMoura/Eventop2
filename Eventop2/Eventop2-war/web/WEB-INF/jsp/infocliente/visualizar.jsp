<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar informações de clientes</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssMenu.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        ${returnMsg}
        ${returnMsg=null}
        <div class="container">
            <h3>Visualizar informações de clientes</h3>          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>NOME COMPLETO</td> 
                        <td>EMAIL</td> 
                        <td>TELEFONE</td> 
                        <td>CPF</td> 

                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${infoClientes}" var="infoCliente">
                        <tr>
                            <td>${infoCliente.idinfocliente}</td>
                            <td>${infoCliente.nomecliente}</td>
                            <td>${infoCliente.email}</td>
                            <td>${infoCliente.telefone}</td>
                            <td>${infoCliente.cpf}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
