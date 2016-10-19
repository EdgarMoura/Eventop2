<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar usuários do evento:</title>
        <link rel="icon" href="img/favicon.ico" />
         <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        
        <div class="container">
            ${errormsg}
            ${errormsg=null}
            <h3>Visualizar clientes</h3>        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>USERNAME</td> 
                        <td>PASSWORD</td> 
                        <td>PERMISSAO</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${usuarioClientes}" var="usuarioCliente">
                        <tr>
                            <td>${usuarioCliente.idusuariocliente}</td>
                            <td>${usuarioCliente.username}</td>
                            <td>${usuarioCliente.senha}</td>
                            <td>${usuarioCliente.fkPermissao}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="container">
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Alterar usuários da Eventop:</legend>
                        <label>Usuários da Eventop:</label> 
                        <p><select name="usuarioClientes">
                                <option value="">-- Selecione um username --</option>
                                <c:forEach items="${usuarioClientes}" var="usuarioCliente">
                                    <option value="${usuarioCliente.idusuariocliente}">${usuarioCliente.username}</option>
                                </c:forEach>
                            </select></p>
                        <label>Novo username:</label>  <p><input type="text" name="username" required="required"/></p>
                        <label>Nova senha:</label>  <p><input type="password" name="senha"  required="required"/></p>
                        <label>Tipo de Usuário</label>
                        <p><select name="permissoes">
                                <option value="">-- Selecione um tipo de usuario --</option>
                                <c:forEach items="${permissoes}" var="permissao">
                                    <option value="${permissao.idpermissao}">${permissao.titlo}</option>
                                </c:forEach>
                            </select></p>
                        <input type="hidden" name="command" value="UsuarioCliente" />
                        <input type="hidden" name="action" value="atualiza.confirma" />
                        <p><input type="submit" value="Alterar" /></p>
                    </form>
                </fieldset>     
            </article>
        </div>
    </body>
</html>
