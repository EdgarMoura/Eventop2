<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar todos os dados de usuários da Eventop</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf"%>

        ${returnMsg}
        ${returnMsg=null}
        <div class="container">
            <h3>Visualizar todos os dados de usuário</h3>        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>NOME DE USUÁRIO</td> 
                        <td>SENHA</td> 
                        <td>PERMISSAO DO USUARIO</td>
                        <td>NOME COMPLETO</td> 
                        <td>EMAIL</td> 
                        <td>ANIVERSÁRIO</td>
                        <td>CPF</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarioClientes}" var="usuarioCliente">
                        <tr>
                            <td>${usuarioCliente.idusuariocliente}</td>
                            <td>${usuarioCliente.username}</td>
                            <td>${usuarioCliente.senha}</td>
                            <td>${usuarioCliente.idpermissao}</td>
                            <td>${usuarioCliente.infoCliente.nomecliente}</td>
                            <td>${usuarioCliente.infoCliente.email}</td>
                            <td>${usuarioCliente.infoCliente.dtaniversario}</td>
                            <td>${usuarioCliente.infoCliente.cpf}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
