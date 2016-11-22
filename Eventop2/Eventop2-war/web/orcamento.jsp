<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
       <title>Solicitar orçamento</title>
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <!--  
                            <br />
                            <br />
        
                        <ul id="adajaxmenu" class="admenus">
                             <li><a href='/'><i class='fa fa-home fa-lg'></i></a></li>    
                            <li><a class="" href="FrontController?command=Usuario&action=index">EvenTOP</a></li>
                            <li class=""><a href="FrontController?command=Usuario&action=index">Home</a></li>
                            <li id="left"><a class="left" href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user" class="left"></span> Sign Up</a></li>
                            <li id="left2"><a class="left" href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in" class="left"></span> Login</a></li>
                </ul>
        -->
        <%@include file="WEB-INF/jsp/menu.jspf" %>   
        <div class='clear'/>    
        <div class='post-body'>
            ${errormsg}
            ${errormsg=null}
            ${sucessmsg}
            ${sucessmsg=null}
            <h2 class='post-title'>Solicite seu orçamento</h2>        
            <form action="FrontController" method="POST">

                <label for="nome">Nome</label>
                <input class="form-control" type="text" name="nome" placeholder="Nome completo" value="${username.infoCliente.nomecliente}" required="required">

                <label for="email">E-mail</label>
                <input class="form-control" type="email" name="email" placeholder="E-mail" value="${username.infoCliente.email}" required="required">

                <label for="telefone">Telefone</label>
                <input class="form-control" type="tel" name="telefone" placeholder="Telefone fixo ou Celular" value="${username.infoCliente.telefone}" required="required">

                <label for="tema">Tema</label>
                <select class="form-control" name="tema">
                    <option value="Infantil">Infantil</option>
                    <option value="Aniversario">Aniversário</option>
                    <option value="Casamento">Casamento</option>
                    <option value="Formatura">Formatura</option>
                </select>

                <label for="qtdPart">Participantes</label>
                <input class="form-control" type="number" name="participantes" placeholder="Quantidade de Participantes" required>

                <label for="data">Data</label>
                <input class="form-control" type="date" name="data" placeholder="Data" required>

                <label for="periodo">Período</label>
                <select class="form-control" name="periodo">
                    <option value="Vespertino">Vespertino</option>
                    <option value="matutino">Matutino</option>
                    <option value="Noturno">Noturno</option>
                </select>

                <label for="descricao">Descrição</label>
                <textarea class="form-control" type="text" name="descricao" placeholder="Digite uma descrição" rows="5" cols="55"></textarea>
                <input type="hidden" name="idAfiliado" value="${username.idusuariocliente}">
                <input type="hidden" name="command" value="Solicitacao"/>   
                <input type="hidden" name="action" value="solicitacao" />
                <input class="form-control" type="submit" value="Enviar">
            </form>
        </div>
    </div>

</body>
</html>

