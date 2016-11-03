<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Serviços</title>
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
            <c:when test="${username.fkPermissao.titlo=='Fornecedor'}">
                <div class="container">
                    ${errormsg}
                    ${errormsg=null}
                    <h3>Seus Serviços</h3>          
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>ID_SERVIÇO</td>
                                <td>TIPO DO SERVIÇO</td> 
                                <td>DESCRIÇÃO</td> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${servicos}" var="servico">
                                <c:if test="${servico.fkUsuarioFornecedor.idusuariocliente == username.idusuariocliente}">
                                    <tr>
                                        <td>${servico.idServico}</td>
                                        <td>${servico.tipoServico}</td>
                                        <td>${servico.descricao}</td>
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
                                <legend>Alterar seus Serviços</legend>
                                <label>Serviços: </label> 
                                <p><select name="servicos">
                                        <option value="" required="required">-- Selecione o anuncio a ser removido --</option>
                                        <c:forEach items="${servicos}" var="servico">
                                            <c:if test="${servico.fkUsuarioFornecedor.idusuariocliente == username.idusuariocliente}">
                                                <option value="${servico.idServico}">${servico.idServico} - ${servico.tipoServico}</option>
                                            </c:if>
                                        </c:forEach> 
                                    </select></p>
                                <legend>Alterar Serviço</legend>
                                <label>Alterar o tipo de Serviço: </label>
                                <p><select name="tpServico">
                                        <option value="" required="required">-- Selecione o tipo do serviço --</option>
                                        <option value="Bebidas">Bebidas</option>
                                        <option value="Brinquedos infantis">Brinquedos infantis</option>
                                        <option value="Comidas">Comidas</option>
                                        <option value="Decoração">Decoração</option>
                                        <option value="Fotografia">Fotografia</option>
                                        <option value="Entretenimento">Entretenimento</option>
                                        <option value="Sonorização">Sonorização</option>
                                        <option value="Outros">Outros</option>
                                    </select></p>
                                <label>Descreve seus Serviços</label>
                                <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                                <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                                <input type="hidden" name="command" value="Servico" />   
                                <input type="hidden" name="action" value="atualiza.confirma" />
                                <p><input type="submit" value="Atualizar" /></p>
                            </form>
                            </div>
                        </c:when>
                        <c:when test="${username.fkPermissao.titlo=='Admin'}">
                            <div class="container">
                                ${errormsg}
                                ${errormsg=null}
                                <h3>Serviços</h3>          
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <td>ID_SERVIÇO</td>
                                            <td>TIPO DO SERVIÇO</td> 
                                            <td>DESCRIÇÃO</td> 
                                            <td>ID_FORNECEDOR</td> 
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${servicos}" var="servico">
                                            <tr>
                                                <td>${servico.idServico}</td>
                                                <td>${servico.tipoServico}</td>
                                                <td>${servico.descricao}</td>
                                                <td>${servico.fkUsuarioFornecedor}</td>
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
                                            <p><select name="servicos">
                                                    <option value="" required="required">-- Selecione o anuncio a ser removido --</option>
                                                    <c:forEach items="${servicos}" var="servico">
                                                        <option value="${servico.idServico}">${servico.idServico} - ${servico.tipoServico}</option>
                                                    </c:forEach> 
                                                </select></p>
                                            <legend>Alterar Serviço</legend>
                                            <label>Alterar o tipo de Serviço: </label>
                                            <p><select name="tpServico">
                                                    <option value="" required="required">-- Selecione o tipo do serviço --</option>
                                                    <option value="Bebidas">Bebidas</option>
                                                    <option value="Brinquedos infantis">Brinquedos infantis</option>
                                                    <option value="Comidas">Comidas</option>
                                                    <option value="Decoração">Decoração</option>
                                                    <option value="Fotografia">Fotografia</option>
                                                    <option value="Entretenimento">Entretenimento</option>
                                                    <option value="Sonorização">Sonorização</option>
                                                    <option value="Outros">Outros</option>
                                                </select></p>
                                            <label>Descreve seus Serviços</label>
                                            <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                                            <p><select name="fkuser">
                                                    <option value="" required="required">-- Selecione o id do anuncio do usuario a ser alterado --</option>
                                                    <c:forEach items="${fkuser}" var="usuarioCliente">
                                                        <option value="${usuarioCliente.idusuariocliente}">${usuarioCliente.idusuariocliente} - ${usuarioCliente.username}</option>
                                                    </c:forEach> 
                                                </select></p>
                                            <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                                            <input type="hidden" name="command" value="Servico" />   
                                            <input type="hidden" name="action" value="atualiza.confirma" />
                                            <p><input type="submit" value="Atualizar" /></p>
                                        </form>
                                        </div> 
                                    </c:when>
                                </c:choose>
                                </body>
                                </html>
