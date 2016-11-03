<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remover Servi�os</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file= "../menu.jspf"%>
        <c:choose>
            <c:when test="${username.fkPermissao.titlo=='Fornecedor'}">
                <div class="container">
                    <article>  
                        <fieldset class="cadastro"> 
                            <form action="FrontController" method="POST" id="cadastro">
                                <legend>Remover Servi�os</legend>
                                <label>Remover seus servi�os: </label> 
                                <p><select name="servicos">
                                        <option value="">-- Selecione o anuncio a ser removido --</option>
                                        <c:forEach items="${servicos}" var="servico">
                                            <c:if test="${servico.fkUsuarioFornecedor.idusuariocliente == username.idusuariocliente}">
                                                <option value="${servico.idServico}">${servico.idServico} - ${servico.tipoServico}</option>
                                            </c:if>
                                        </c:forEach> 
                                    </select></p>
                                <input type="hidden" name="command" value="Servico" />
                                <input type="hidden" name="action" value="deleta.confirma" />
                                <p><input type="submit" value="Remover" /></p>
                            </form>
                        </fieldset>
                    </article>
                </div>
            </c:when>
            <c:otherwise>
                <div class="container">
                    <h3>Servi�os</h3>          
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>ID_SERVI�O</td>
                                <td>TIPO DO SERVI�O</td> 
                                <td>DESCRI��O</td> 
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${servicos}" var="servico">
                                <tr>
                                    <td>${servico.idServico}</td>
                                    <td>${servico.tipoServico}</td>
                                    <td>${servico.descricao}</td>
                                </tr>                                
                            </c:forEach>
                        </tbody>
                    </table>
                    <article>  
                        <fieldset class="cadastro"> 
                            <form action="FrontController" method="POST" id="cadastro">
                                <legend>Remover Servi�os</legend>
                                <label>Remover Servi�os dos fornecedores</label> 
                                <p><select name="servicos">
                                        <option value="">-- Selecione o anuncio a ser exclu�do --</option>     
                                        <c:forEach items="${servicos}" var="servico">
                                            <option value="${servico.idServico}">${servico.idServico} - ${servico.tipoServico} </option>
                                        </c:forEach> 
                                    </select></p>
                                <input type="hidden" name="command" value="Servico" />
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
