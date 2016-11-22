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
            <h3>Dados da sua Solicitação</h3>
            <tr class="topo">
                <td>Nome:</td>
                <td>Email</td>
                <td>Telefone</td>
                <td>Data:</td>
                <td>Período:</td>
                <td>Tema:</td>
                <td>Participantes</td>
                <td>Descrição:</td>
            </tr>
            
            <c:forEach items="${orcamento}" var="o">
                
                <c:if test="${o.fkSolicitacao.fkUsuarioCliente == username}">
                    <tr>
                        <td>${o.fkSolicitacao.nome}</td>
                        <td>${o.fkSolicitacao.email}</td>
                        <td>${o.fkSolicitacao.fkUsuarioCliente.infoCliente.telefone}</td>
                        <td>${o.fkSolicitacao.dataEvento}</td>
                        <td>${o.fkSolicitacao.periodo}</td>
                        <td>${o.fkSolicitacao.tema}</td>
                        <td>${o.fkSolicitacao.qtdPessoas}</td>
                        <td>${o.fkSolicitacao.descricao}</td>
                    </tr>
                </c:if>                                     
            </c:forEach>

        </table>
        
        <table class="tabela">
        <h3>Dados do Orçamento do Promoter</h3>
        <h4 style="text-align: center;">Informações do Local</h4>
        <tr class="topo">
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
        <table class="tabela">
        <h4 style="text-align: center;">Brinquedos</h4>
        <tr class="topo">
            <td>Nome</td>
            <td>Valor</td>
        </tr>
            <c:forEach items="${produto}" var="prod">
                <c:if test="${prod.fkOrcamento.fkSolicitacao.fkUsuarioCliente == username}">
                <tr>   
                <td>${prod.nome}</td>
                <td>${prod.valor}</td>
                </tr>
              </c:if>                        
            </c:forEach>           
        </table>
        <table class="tabela">
        <h4 style="text-align: center;">Informações do Promoter</h4>
        <tr class="topo">
            <td>Nome</td>
            <td>Email</td>
            <td>Telefone</td>
        </tr>
        
            <c:forEach items="${infocliente}" var="info">
                <c:if test="${info.getUsuarioCliente().getOrcamentoList().isEmpty() == false}">
                  <c:forEach begin="0" end="${info.getUsuarioCliente().getOrcamentoList().size() - 1}" varStatus="i" var="items">  
                      
                      <tr>
                        <td> ${info.nomecliente}</td>
                        <td>${info.email}</td>
                        <td>${info.telefone}</td>
                       </tr>      
                     
                    </c:forEach>     
                  </c:if>
                </c:forEach>                
        </table>
    </body>

</html>
