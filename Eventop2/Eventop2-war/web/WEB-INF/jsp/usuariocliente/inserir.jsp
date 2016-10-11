<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir usuários do evento</title>
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
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Inserir usuários do evento</legend>
                        <label>Novo username:</label> <p><input type="text" name="username" required="required"/></p>
                        <label>Nova senha:</label> <p><input type="text" name="senha" required="required"/></p>
                        <label>Tipo de Usuário</label>
                        <p><select name="permissoes">
                                <option value="">-- Selecione um tipo de usuario --</option>
                                <c:forEach items="${permissoes}" var="permissao">
                                    <option value="${permissao.idpermissao}">${permissao.titlo}</option>
                                </c:forEach>
                            </select></p>
                        <input type="hidden" name="command" value="UsuarioCliente" />
                        <input type="hidden" name="action" value="insere.confirma" />
                        <p><input type="submit" value="Inserir" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
