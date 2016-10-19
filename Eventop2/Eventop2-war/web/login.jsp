
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link href="css/LoginBootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <style>
		#fundo {background-image: url("img/aladim.gif");color: white;}
	  </style>
        <title>Login EvenTOP</title>
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
			<li><a href="#">Orcamento</a></li>
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
        <form action="FrontController" method="POST">
            <h1>Digite o seu login para entrar</h1>
            <div class="inset">
                <p>
                    <label for="email">USERNAME</label>
                    <input type="text" name="username" id="email"  value="${cookie.usernameCookie.value}">
                </p>
                <p>
                    <label for="password">SENHA</label>
                    <input type="password" name="senha" id="password"  value="${cookie.passwordCookie.value}">
                </p>
                <p>
                    <input type="checkbox" name="remember"  name="on" id="remember" checked="checked">
                    <label for="remember">Mantenha-me conectado</label>
                </p>
            </div>
            <p class="p-container">
                <span>Forgot password ?</span>
                <input type="hidden" name="command" value="Usuario" />
                <input type="hidden" name="action" value="login" />
                <input type="submit" name="go" id="go" value="Entrar">
            ${errormsg}
            ${errormsg=null}
            </p>
        </form>
    </body>
</html>
