<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar anuncios</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script>
            function formatar(mascara, documento) {
                var i = documento.value.length;
                var saida = mascara.substring(0, 1);
                var texto = mascara.substring(i)

                if (texto.substring(0, 1) != saida) {
                    documento.value += texto.substring(0, 1);
                }

            }
        </script>

    </head>
    <body>
        <%@include file="../menu.jspf" %>
        <c:choose>
            <c:when test="${username.fkPermissao.titlo=='Promoter'}">
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
                <div class="container">
                    <article>  
                        <fieldset class="cadastro"> 
                            <form action="FrontController" method="POST" id="cadastro">
                                <legend>Alterar seus anúncios</legend>
                                <label>Anuncios: </label> 
                                <p><select name="anuncios">
                                        <option value="">-- Selecione o anuncio a ser removido --</option>
                                        <c:forEach items="${anuncios}" var="anuncio">
                                            <c:if test="${anuncio.fkUsuario.idusuariocliente == username.idusuariocliente}">
                                                <option value="${anuncio.idAnuncio}">${anuncio.idAnuncio} - ${anuncio.tipoAnuncio}</option>
                                            </c:if>
                                        </c:forEach> 
                                    </select></p>
                                <legend>Alterar Anuncio</legend>
                                <label>Alterar o tipo de anúncio: </label>
                                <p><select name="tpAnuncio">
                                        <option value="">-- Selecione o tipo de Anúncio --</option>
                                        <option value="Buffet de Casamento">Buffet de Casamento</option>
                                        <option value="Festas Infantis">Festas Infantis</option>
                                        <option value="Debutante">Debutante</option>
                                        <option value="Outros">Outros</option>
                                    </select></p>
                                <label>Descreve seus Serviços</label>
                                <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                                <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                                <input type="hidden" name="command" value="Anuncio" />   
                                <input type="hidden" name="action" value="atualiza.confirma" />
                                <p><input type="submit" value="Atualizar" /></p>
                            </form>
                            </div>
                        </c:when>
                        <c:when test="${username.fkPermissao.titlo=='Admin'}">
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
                                            <td>ID_USUARIO</td> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${anuncios}" var="anuncio">
                                            <tr>
                                                <td>${anuncio.idAnuncio}</td>
                                                <td>${anuncio.tipoAnuncio}</td>
                                                <td>${anuncio.descricao}</td>
                                                <td>${anuncio.fkUsuario}</td>
                                            </tr>    
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div> 
                            <div class="container">
                                <article>  
                                    <fieldset class="cadastro"> 
                                        <form action="FrontController" method="POST" id="cadastro">
                                            <legend>Alterar seus anúncios</legend>
                                            <label>Anuncios: </label> 
                                            <p><select name="anuncios">
                                                    <option value="">-- Selecione o anuncio a ser removido --</option>
                                                    <c:forEach items="${anuncios}" var="anuncio">
                                                        <option value="${anuncio.idAnuncio}">${anuncio.idAnuncio} - ${anuncio.tipoAnuncio}</option>
                                                    </c:forEach> 
                                                </select></p>
                                            <legend>Alterar Anuncio</legend>
                                            <label>Alterar o tipo de anúncio: </label>
                                            <p><select name="tpAnuncio">
                                                    <option value="">-- Selecione o tipo de Anúncio --</option>
                                                    <option value="Buffet de Casamento">Buffet de Casamento</option>
                                                    <option value="Festas Infantis">Festas Infantis</option>
                                                    <option value="Debutante">Debutante</option>
                                                    <option value="Outros">Outros</option>
                                                </select></p>
                                            <label>Descreve seus Serviços</label>
                                            <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                                            <p><select name="fkuser">
                                                    <option value="">-- Selecione o id do anuncio do usuario a ser alterado --</option>
                                                    <c:forEach items="${fkuser}" var="usuarioCliente">
                                                        <option value="${usuarioCliente.idusuariocliente}">${usuarioCliente.idusuariocliente} - ${usuarioCliente.username}</option>
                                                    </c:forEach> 
                                                </select></p>
                                            <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                                            <input type="hidden" name="command" value="Anuncio" />   
                                            <input type="hidden" name="action" value="atualiza.confirma" />
                                            <p><input type="submit" value="Atualizar" /></p>
                                        </form>
                                        </div> 
                                    </c:when>
                                </c:choose>
                                </body>
                                </html>
