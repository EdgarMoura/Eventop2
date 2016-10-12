<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover usuários da Eventop</title>
        <link rel="icon" href="img/favicon.ico" />
         <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <div class="container">
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Remover clientes</legend>
                        <label>Usuários - Clientes:</label> 
                        <p><select name="usuarioClientes">
                                <option value="">-- Selecione um usuário --</option>
                                <c:forEach items="${usuarioClientes}" var="usuarioCliente">
                                    <option value="${usuarioCliente.idusuariocliente}">${usuarioCliente.username}</option>
                                </c:forEach>
                            </select></p>
                        <input type="hidden" name="command" value="UsuarioCliente" />
                        <input type="hidden" name="action" value="deleta.confirma" />
                        <p><input type="submit" value="Remover" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
