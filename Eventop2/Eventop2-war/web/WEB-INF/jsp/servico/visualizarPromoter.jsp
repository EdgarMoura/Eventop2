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

        <div class="container">
            <h3>Lista de Fornecedores</h3>          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>NOME DO FORNECEDOR</td>
                        <td>EMAIL</td> 
                        <td>TELEFONE</td> 
                        <td>CNPJ</td>
                        <td>ID_SERVICO</td>
                        <td>TIPO DO SERVIÇO</td> 
                        <td>DESCRIÇÃO</td> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${infoClientes}" var="infoCliente">                                
                        <c:if test="${infoCliente.getUsuarioCliente().getServicoList().isEmpty() == false}">
                            <c:forEach begin="0" end="${infoCliente.getUsuarioCliente().getServicoList().size() -1}" varStatus="i" var="items">  
                                <tr>
                                    <td>${infoCliente.nomecliente}</td>
                                    <td>${infoCliente.email}</td>
                                    <td>${infoCliente.telefone}</td>
                                    <td>${infoCliente.cnpj}</td>
                                    <td>${infoCliente.getUsuarioCliente().getServicoList().get(i.index).getIdServico()} </p>
                                    <td>${infoCliente.getUsuarioCliente().getServicoList().get(i.index).getTipoServico()} </p>
                                    <td>${infoCliente.getUsuarioCliente().getServicoList().get(i.index).getDescricao()} </p>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div> 
    </body>
</html>

