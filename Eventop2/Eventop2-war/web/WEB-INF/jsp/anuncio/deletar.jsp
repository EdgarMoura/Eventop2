<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Anuncios</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file= "../menu.jspf"%>
        <c:choose>
            <c:when test="${username.fkPermissao.titlo='Promoter'}">
                <div class="container">
                    <article>  
                        <fieldset class="cadastro"> 
                            <form action="FrontController" method="POST" id="cadastro">
                                <legend>Remover Anúncios</legend>
                                <label>Remover seus anúncios: </label> 
                                <p><select name="anuncios">
                                        <option value="">-- Selecione o anúncio a ser excluído --</option>     
                                        <c:forEach items="${anuncios}" var="anuncio">
                                            <c:if test="${anuncio.fkUsuario.idusuariocliente == username.idusuariocliente}">
                                                <option value="${anuncio.idAnuncio}">${anuncio.idAnuncio} - ${anuncio.tipoAnuncio}</option>
                                            </c:if>
                                        </c:forEach> 
                                    </select></p>
                                <input type="hidden" name="command" value="Anuncio" />
                                <input type="hidden" name="action" value="deleta.confirma" />
                                <p><input type="submit" value="Remover" /></p>
                            </form>
                        </fieldset>
                    </article>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <article>  
                        <fieldset class="cadastro"> 
                            <form action="FrontController" method="POST" id="cadastro">
                                <legend>Remover Anúncios</legend>
                                <label>Remover Anúncios dos promoteries</label> 
                                <p><select name="anuncios">
                                        <option value="">-- Selecione o anuncio a ser excluído --</option>     
                                        <c:forEach items="${anuncios}" var="anuncio">
                                            <option value="${anuncio.idAnuncio}">${anuncio.idAnuncio} - ${anuncio.tipoAnuncio}</option>
                                        </c:forEach> 
                                    </select></p>
                                <input type="hidden" name="command" value="Anuncio" />
                                <input type="hidden" name="action" value="deleta.confirma" />
                                <p><input type="submit" value="Remover" /></p>
                            </form>
                        </fieldset>
                    </article>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
