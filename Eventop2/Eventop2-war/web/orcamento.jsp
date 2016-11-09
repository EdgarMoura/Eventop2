<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Solicitar orçamento</title>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${username.fkPermissao.titlo=='Cliente'}">
                <%@include file="WEB-INF/jsp/menu.jspf" %>
                <div class="container">
                    ${errormsg}
                    ${errormsg=null}
                    ${sucessmsg}
                    ${sucessmsg=null}
                    <article>  
                        <fieldset class="cadastro">
                            <form action="FrontController" method="POST">
                                <label for="nome">Nome</label>
                                <input class="form-control" type="text" name="nome" placeholder="Nome completo" required>

                                <label for="email">E-mail</label>
                                <input class="form-control" type="email" name="email" placeholder="E-mail" required>

                                <label for="telefone">Telefone</label>
                                <input class="form-control" type="tel" name="telefone" placeholder="Telefone fixo ou Celular" required>

                                <label for="tema">Tema</label>
                                <select name="tema">

                                    <option value="Infantil">Infantil</option>
                                    <option value="Aniversario"Aniversário</option>
                                    <option value="Casamento">Casamento</option>
                                    <option value="Formatura">Formatura</option>

                                </select>

                                <label for="qtdPart">Participantes</label>
                                <input class="form-control" type="number" name="participantes" placeholder="Quantidade de Participantes" required>

                                <label for="data">Data</label>
                                <input class="form-control" type="date" name="data" placeholder="Data" required>
                                <label for="periodo">Período</label>
                                <select name="periodo">

                                    <option value="Vespertino">Vespertino</option>
                                    <option value="matutino">Matutino</option>
                                    <option value="Noturno">Noturno</option>

                                </select>

                                <label for="descricao">Descrição</label>
                                <textarea class="form-control1" type="text" name="descricao" placeholder="Digite uma descriçaõ" rows="5" cols="55"></textarea>
                                <input type="hidden" name="command" value="Evento"/>   
                                <input type="hidden" name="action" value="soliOrcamento" />
                                <input class="form-control2" type="submit" value="Enviar">
                            </form>
                        </fieldset>     
                    </article>
                </div>
            </c:when>
            <c:otherwise>

                <style>
                    #fundo {background-image: url("img/aladim.gif");color: white;}
                </style>
                <div class="jumbotron text-center" id="fundo">
                    <h1>Seja Bem Vindo, ao EvenTop</h1>
                    <p> Os melhores eventos estão aqui!!!</p> 

                </div>
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span> 
                            </button>
                            <a class="navbar-brand" href="FrontController?command=Usuario&action=index">Eventop</a>
                        </div>
                        <div class="collapse navbar-collapse" id="myNavbar">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="FrontController?command=Usuario&action=index">Home</a></li>
                                <li><a href="FrontController?command=Usuario&action=orcamento">Solicitar orçamento</a></li>
                                <li><a href="#">Page 2</a></li> 
                                <li><a href="#">Page 3</a></li> 
                            </ul>
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                                <li><a href="FrontController?command=Usuario&action=login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>

                
                <div class='clear'/>    
                <div class='post-body'>
                    ${errormsg}
                    ${errormsg=null}
                    ${sucessmsg}
                    ${sucessmsg=null}
                    <h2 class='post-title'>Solicite seu orçamento</h2>        
                    <form action="FrontController" method="POST">

                        <label for="nome">Nome</label>
                        <input class="form-control" type="text" name="nome" placeholder="Nome completo" required>

                        <label for="email">E-mail</label>
                        <input class="form-control" type="email" name="email" placeholder="E-mail" required>

                        <label for="telefone">Telefone</label>
                        <input class="form-control" type="tel" name="telefone" placeholder="Telefone fixo ou Celular" required>

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
                        <input type="hidden" name="command" value="Evento"/>   
                        <input type="hidden" name="action" value="soliOrcamento" />
                        <input class="form-control" type="submit" value="Enviar">
                    </form>
                </div>

            </div>



        </c:otherwise>
    </c:choose>
</body>
</html>

