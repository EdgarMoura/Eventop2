<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover permiss�o de Usuario</title>
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
                        <legend>Remover permiss�es de usu�rio</legend>
                        <label>Tipos de usu�rios: </label> 
                        <p><select name="permissoes">
                                <option value="">-- Selecione um tipo de usu�rio --</option>
                                <c:forEach items="${permissoes}" var="permissao">
                                    <option value="${permissao.idpermissao}">${permissao.titlo}</option>
                                </c:forEach>
                            </select></p>
                        <input type="hidden" name="command" value="Permissao" />
                        <input type="hidden" name="action" value="deleta.confirma" />
                        <p><input type="submit" value="Remover" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
