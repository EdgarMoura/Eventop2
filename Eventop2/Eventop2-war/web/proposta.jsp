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
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>

    <body>
        <%@include file="WEB-INF/jsp/menu.jspf" %>

        <table class="tabela">
            <h3>Dados da sua Solicita��o</h3>
            <hr />
            <tr class="topo">
                <td>ID Or�amento</td>
                <td>Nome:</td>
                <td>Email</td>
                <td>Telefone</td>
                <td>Data:</td>
                <td>Per�odo:</td>
                <td>Tema:</td>
                <td>Participantes</td>
                <td>Descri��o:</td>
            </tr>

            <c:forEach items="${orcamento}" var="o">

                <c:if test="${o.fkSolicitacao.fkUsuarioCliente == username}">
                    <tr>
                        <td>${o.idOrcamento}</td>
                        <td>${o.fkSolicitacao.nome}</td>
                        <td>${o.fkSolicitacao.email}</td>
                        <td>${o.fkSolicitacao.fkUsuarioCliente.infoCliente.telefone}</td>
                        <td>${o.fkSolicitacao.getDataEventoFormatted()}</td>
                        <td>${o.fkSolicitacao.periodo}</td>
                        <td>${o.fkSolicitacao.tema}</td>
                        <td>${o.fkSolicitacao.qtdPessoas}</td>
                        <td>${o.fkSolicitacao.descricao}</td>
                    </tr>
                </c:if>                                     
            </c:forEach>

        </table>

        <table class="tabela">
            <h3>Dados do Or�amento do Promoter</h3>
            <hr />
            <h4 style="text-align: center;">Informa��es do Local</h4>
            <tr class="topo">
                <td>ID Or�amento</td>
                <td>Logradouro</td>
                <td>Numero</td>
                <td>Bairro</td>
                <td>Cep</td>
                <td>Cidade</td>
                <td>Estado</td>
                <td>Capacidade</td>
                <td>Valor</td>
                <td>Descricao do Local</td>
            </tr>
            <c:forEach items="${orcamento}" var="orc">
                <c:if test="${orc.fkSolicitacao.fkUsuarioCliente == username}">
                    <tr>   
                        
                        <td>${orc.idOrcamento}</td>
                        <td>${orc.endereco.logradouro}</td>
                        <td>${orc.endereco.numero}</td>
                        <td>${orc.endereco.bairro}</td>
                        <td>${orc.endereco.cep}</td>
                        <td>${orc.endereco.cidade}</td>
                        <td>${orc.endereco.estado}</td>
                        <td>${orc.endereco.capacidade}</td>
                        <td>${orc.endereco.valor}</td>
                        <td>${orc.endereco.descricao}</td>
                    </tr>
                </c:if>                        
            </c:forEach>           
        </table>
        <hr />
        <table class="tabela">
            <h4 style="text-align: center;">Produtos</h4>
            <tr class="topo">
                <td>ID Or�amento</td>
                <td>Nome</td>
                <td>Valor</td>
            </tr>
            <c:forEach items="${produto}" var="prod">
                <c:if test="${prod.fkOrcamento.fkSolicitacao.fkUsuarioCliente == username}">
                    <tr>   
                        <td>${prod.fkOrcamento.idOrcamento}</td>
                        <td>${prod.nome}</td>
                        <td>${prod.valor}</td> 
                    </tr>
                </c:if>                        
            </c:forEach>           
        </table>
          <hr />
        <table class="tabela">
            <h4 style="text-align: center;">Informa��es do Promoter</h4>
            <tr class="topo">
                <td>ID Or�amento</td>
                <td>Nome</td>
                <td>Email</td>
                <td>Telefone</td>
            </tr>
            <c:forEach items="${orcamento}" var="orc">
                <c:if test="${orc.fkSolicitacao.fkUsuarioCliente == username}">
                    <tr>   
                        <td>${orc.idOrcamento}</td>
                        <td>${orc.fkUsuariopromoter.infoCliente.nomecliente}</td>
                        <td>${orc.fkUsuariopromoter.infoCliente.email}</td>
                        <td>${orc.fkUsuariopromoter.infoCliente.telefone}</td>
                    </tr>
                </c:if>                        
            </c:forEach>       
        </table>
          <hr />
    </body>

</html>
