<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar serviços</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssMenu.css" rel="stylesheet" />
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>
         <c:choose>
            <c:when test="${username.fkPermissao.titlo=='Fornecedor'}">
               
                ${returnMsg}
                ${returnMsg=null}
                <div class="container">
                    ${errormsg}
                    ${errormsg=null}
                    <h3>Seus Serviços</h3>          
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <td>ID_SERVICO</td>
                                <td>TIPO DO SERVICO</td> 
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
            </c:when>
            <c:when test="${username.fkPermissao.titlo=='Admin'}">
                ${returnMsg}
                ${returnMsg=null}
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
            </c:when>  
        </c:choose>      
    </body>
</html>
