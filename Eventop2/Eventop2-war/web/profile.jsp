<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Perfil</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="userAdmin/jsp/menu.jspf" %>
        <div class="container">
            <article>  
                <fieldset class="cadastro">
                    <form id="cadastro" >
                        <legend>Dados da sua conta</legend>
                        <label>Nome completo: </label><p><input type="text" name="fullname" value="${username.infoUser.fullname}" readonly="readonly"/></p>
                        <label>Nome de Usuário: </label><p><input type="text" name="username" value="${username.username}" readonly="readonly" /></p>
                        <label>Email: </label><p><input type="email" name="email" value="${username.infoUser.email}" readonly="readonly"/></p>
                        <label>Data de aniversário:</label><p><input type="text" name="bday" value="${username.infoUser.birthday}" readonly="readonly" /></p>
                    </form>
                </fieldset>     
            </article>
        </div>         
    </body>
</html>
