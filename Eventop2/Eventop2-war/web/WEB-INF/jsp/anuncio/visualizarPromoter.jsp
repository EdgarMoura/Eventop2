<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar anuncios</title>
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
            ${errormsg}
            ${errormsg=null}
            <h3>Seus Anuncios</h3>          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID_ANUNCIO</td>
                        <td>TIPO DO ANUNCIO</td> 
                        <td>DESCRIÇÃO</td> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${anuncios}" var="anuncio">
                        <c:if test="${anuncio.fkUsuario.idusuariocliente == username.idusuariocliente}">
                            <tr>
                                <td>${anuncio.idAnuncio}</td>
                                <td>${anuncio.tipoAnuncio}</td>
                                <td>${anuncio.descricao}</td>
                            </tr>
                        </c:if>                                     
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
