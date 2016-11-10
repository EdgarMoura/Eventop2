
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link href="css/LoginBootstrap.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <style>
		body{background: #f9f9f9;}
	  </style>
        <title>Login EvenTOP</title>
    </head>
    <body>
        <br />
        <div class="container center">
       
	<ul id="adajaxmenu" class="admenus">
                     <li><a href='/'><i class='fa fa-home fa-lg'></i></a></li>    
                    <li><a class="" href="FrontController?command=Usuario&action=index">EvenTOP</a></li>
                    <li class=""><a href="FrontController?command=Usuario&action=index">Home</a></li>
                    <li id="left"><a class="left" href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user" class="left"></span> Sign Up</a></li>
                    <li id="left2"><a class="left" href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in" class="left"></span> Login</a></li>
        </ul>
            <br />
        <form action="FrontController" method="POST">
            <h1 style="color:#fff;">Digite o seu login para entrar</h1>
            <div class="inset">
                <p>
                    <label for="email" style="color:#fff;">USERNAME</label>
                    <input type="text" name="username" id="email"  value="${cookie.usernameCookie.value}">
                </p>
                <p>
                    <label for="password" style="color:#fff;">SENHA</label>
                    <input type="password" name="senha" id="password"  value="${cookie.passwordCookie.value}">
                </p>
                <p>
                    <input type="checkbox" name="remember"  name="on" id="remember" checked="checked">
                    <label for="remember" style="color:#fff;">Mantenha-me conectado</label>
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
           </div>
    </body>
</html>
