<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Eventop</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

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
        <li><a href="FrontController?command=Anuncio&action=mostrar">Anúncios</a></li> 
        <li><a href="#">Page 3</a></li> 
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
        <li><a href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
 section>
            <fieldset class="cadastro">
                
                <legend>Anuncios</legend>
                <img src="img/inserirFoto2.png" alt="logo" class="img"/>
                <c:forEach items="infoClientes" var="infoCliente">
                <p><b>Nome: ${infoCliente.idinfocliente}</b><br/>
                <p><b>Nome: ${infoCliente.nomecliente}</b><br/>
                <b>Email: ${infoCliente.email}</b><br/>
                <b>Telefone: ${infoCliente.telefone}</b><br/>
                </c:forEach>
                
<div class="container">
  <div class="row">
    <div class="col-sm-4">
      <h3>Column 1</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
      <h3>Column 2</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
    <div class="col-sm-4">
      <h3>Column 3</h3>        
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit...</p>
      <p>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris...</p>
    </div>
  </div>
</div>

</body>
</html>

