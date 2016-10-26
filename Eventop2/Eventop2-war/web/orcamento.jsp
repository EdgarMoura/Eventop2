<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>EvenTOP</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>
    <body>
        <c:choose>
            <c:when test="${username.fkPermissao.titlo=='Cliente'}">
                <%@include file="WEB-INF/jsp/menu.jspf" %>
                <div class="container">
                    <form>
                        <div class="form-group">
                            <label for="data">Data do Evento</label>
                            <input type="date" class="form-control" id="data" >
                        </div>
                        <div class="form-group">
                            <label for="convidados">Quantidade de Convidados</label>
                            <input type="number" class="form-control" id="convidados" >
                        </div>
                        <div class="form-group">
                            <label for="periodo">Período</label>
                            <select class="form-control" id="periodo">
                                <option>Matutino</option>
                                <option>Vespertino</option>
                                <option>Noturno</option>
                                <option>Diurno</option>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="local">Local</label>
                            <select class="form-control" id="local">
                                <option>Sítio</option>
                                <option>Parque</option>
                                <option>Condomínio</option>
                                <option>Outros</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="area">Area</label>
                            <select class="form-control" id="area">
                                <option>Coberta</option>
                                <option>Fechada</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="tema">Decoração por Tema</label>
                            <select class="form-control" id="tema">
                                <option>Homem Aranha</option>
                                <option>Super Man</option>
                                <option>Batman</option>
                                <option>Toy Sorty</option>
                                <option>Minions</option>
                                <option>Frozen</option>
                                <option>Branca de Neve</option>
                                <option>Galinha Pintadinha</option>
                                <option>Barbie</option>
                                <option>Cinderela</option>
                            </select>

                        </div>
                    </form>
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
                                <li><a href="FrontController?command=Usuario&action=orcamento">Orcamento</a></li>
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

                <div class="container">

                    <form>
                        <div class="form-group">
                            <label for="data">Data do Evento</label>
                            <input type="date" class="form-control" id="data" >
                        </div>
                        <div class="form-group">
                            <label for="convidados">Quantidade de Convidados</label>
                            <input type="number" class="form-control" id="convidados" >
                        </div>
                        <div class="form-group">
                            <label for="periodo">Período</label>
                            <select class="form-control" id="periodo">
                                <option>Matutino</option>
                                <option>Vespertino</option>
                                <option>Noturno</option>
                                <option>Diurno</option>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="local">Local</label>
                            <select class="form-control" id="local">
                                <option>Sítio</option>
                                <option>Parque</option>
                                <option>Condomínio</option>
                                <option>Outros</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="area">Area</label>
                            <select class="form-control" id="area">
                                <option>Coberta</option>
                                <option>Fechada</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="tema">Decoração por Tema</label>
                            <select class="form-control" id="tema">
                                <option>Homem Aranha</option>
                                <option>Super Man</option>
                                <option>Batman</option>
                                <option>Toy Sorty</option>
                                <option>Minions</option>
                                <option>Frozen</option>
                                <option>Branca de Neve</option>
                                <option>Galinha Pintadinha</option>
                                <option>Barbie</option>
                                <option>Cinderela</option>
                            </select>

                        </div>
                    </form>
                </div>

            </c:otherwise>
        </c:choose>
    </body>
</html>

