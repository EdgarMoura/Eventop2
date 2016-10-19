
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link href="css/LoginBootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/cssAnuncio.css" rel="stylesheet" type="text/css"/>
         <style>
		#fundo {background-image: url("img/aladim.gif");color: white;}
	  </style>
        <title>Anuncio Eventop</title>
    </head>
    <body>
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
			<li><a href="FrontController?command=Orcamento&action=orcamento">Orcamento</a></li>
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
        

   <header>
        <h1>Anuncios</h1>
        
        
        </header>

       <section>
            <fieldset class="cadastro">
                
                <legend>Anuncios</legend>
                <img src="img/inserirFoto2.png" alt="logo" class="img"/>
                
                <c:forEach items="anuncios" var="anuncio">
                <b>Telefone: ${anuncio.telefone}</b>
                <b>Tipo do anuncio: ${anuncio.idAnuncio} - ${anuncio.tipoAnuncio}</b>
                <b>Descrição</b>
                <p><textarea class="form-control" rows="5" name="descricao" value="${$infoCliente.anuncio.descricao}" readonly="readonly"></textarea></p>
                </c:forEach>             

                
                
            </fieldset><br/>
            
</section>
       
    </body>
</html>
