<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Perfil</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script>
            function formatar(mascara, documento) {
                var i = documento.value.length;
                var saida = mascara.substring(0, 1);
                var texto = mascara.substring(i)

                if (texto.substring(0, 1) != saida) {
                    documento.value += texto.substring(0, 1);
                }

            }
        </script>
    </head>
    <body>
        <%@include file="WEB-INF/jsp/menu.jspf" %>
        <div class="container">
           ${errormsg}
           ${errormsg=null}
           ${sucessmsg}
           ${sucessmsg=null}
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController"  method="POST" id="cadastro" >
                        <legend>Alterar os dados da sua conta</legend>
                        <input type="hidden" name="user" value="${username.username}"/>
                        <input type="hidden" name="fullnameh" value="${username.infoCliente.nomecliente}"/>
                        <label>Nome completo: </label><p><input type="text" name="fullname" value="${username.infoCliente.nomecliente}"/></p>
                        <label>Nome de Usu�rio: </label><p><input type="text" name="username"value="${username.username}"/></p>
                        <label>Senha: </label><p><input type="password" name="pwd1" value="${username.senha}" /></p>
                        <label>Confirmar senha: </label><p><input type="password" name="pwd2" value="${username.senha}"/></p>
                        <label>Email: </label><p><input type="email" name="email" value="${username.infoCliente.email}" /></p>
                        <label>Telefone:</label><p><input type="text" name="telefone" placeholder="(xx)xxxxxxxxx" maxlength="13" OnKeyPress="formatar('(##)#########', this)"required="required" /> *</p>
                        <input type="hidden" name="command" value="Cliente" />
                        <input type="hidden" name="action" value="atualiza.perfil" />
                        <p><input type="submit" value="Alterar" /></p>
                    </form>
                </fieldset>     
            </article>
        </div>
    </body>
</html>

