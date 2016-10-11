<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Perfil</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="userAdmin/jsp/menu.jspf" %>
        <div class="container">
           ${errormsg}
           ${errormsg=null}
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController"  method="POST" id="cadastro" >
                        <legend>Confirmação de remoção da sua conta</legend>
                        <input type="hidden" name="id" value="${username.idUserevent}"/> 
                        <label>Nome de Usuário: </label><p><input type="text" name="username"/></p>
                        <label>Senha: </label><p><input type="password" name="pwd1" /></p>
                        <input type="hidden" name="command" value="User" />
                        <input type="hidden" name="action" value="delete.profile" />
                        <p><input id="botaoRemover" type="submit" value="Remover sua conta" /></p>
                    </form>
                </fieldset>     
            </article>
        </div>
    </body>
</html>

