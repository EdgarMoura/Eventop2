<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Eventop</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/cssIndex.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>

    <body>
        <c:if test="${infoClientes == null}">
            <c:redirect url="FrontController?command=Usuario&action=index"></c:redirect>
        </c:if>
        <div class="jumbotron text-center">
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
                    <a class="navbar-brand" href="FrontController?command=Usuario&action=index">EvenTOP</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="FrontController?command=Usuario&action=index">Home</a></li>
                        <li><a href="FrontController?command=Usuario&action=orcamento">Orçamento</a></li>
                        <li><a href="#">Page 2</a></li> 
                        <li><a href="#">Page 3</a></li> 
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <main>
            <c:forEach items="${infoClientes}" var="infoCliente">
                <c:if test="${infoCliente.getUsuarioCliente().getAnuncioList().isEmpty() == false}">
                    <section>
                        <label>Dados do Promoter</label>
                        <p>Nome: ${infoCliente.nomecliente}</p>
                        <p>Email: ${infoCliente.email}</p>
                        <p>Telefone: ${infoCliente.telefone}<p>
                            <label>Anúncios do promoter </label>
                        <c:forEach begin="0" end="${infoCliente.getUsuarioCliente().getAnuncioList().size() - 1}" varStatus="i" var="items">  
                            <p>ID Anúncio: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getIdAnuncio()} </p>
                            <p>Tipo do Anúncio: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getTipoAnuncio()} </p>
                            <p>Descrição: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getDescricao()} </p>
                        </c:forEach>
                    </section>
                </c:if>
            </c:forEach>    
        </main> 
    </body>
</html>

