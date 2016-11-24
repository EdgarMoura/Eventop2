
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../../../css/orcamento.css" rel="stylesheet" type="text/css"/>
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
        
    </head>
    <body>
         <%@include file="../menu.jspf" %>  
     <h1 class="tituloSolic">Solicitações</h1>
    <table class="tabela">
    <tr class="topo">
        <td>Nome:</td>
        <td>Email</td>
        <td>Telefone</td>
        <td>Data:</td>
        <td>Período:</td>
        <td>Tema:</td>
        <td>Participantes</td>
        <td>Descrição:</td>
        <td>Atender Solicitação</td>
     </tr>
           
        <c:forEach items="${solicitacoes}" var="s" >
    <tr>
        <td>${s.nome}</td>
        <td>${s.email}</td>
        <td>${s.fkUsuarioCliente.infoCliente.telefone}</td>
        <td>${s.getDataEventoFormatted()}</td>
        <td>${s.periodo}</td>
        <td>${s.tema}</td>
         <td>${s.qtdPessoas}</td>
        <td>${s.descricao}</td>
    <form action="FrontController" method="POST">
         <input type="hidden" name="command" value="Orcamento" />   
         <input type="hidden" name="action" value="orcamentoPromoter" />
         <input type="hidden" name="atender" value="${s.idSolicitacao}" />
    <td>
        <input type="submit" value="Atender" />
        
    </td>
    </form>
    </tr>
</c:forEach>
       </table>           
        
    </body>
</html>
