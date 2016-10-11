<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir informações de clientes</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
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
        <%@include file="../menu.jspf" %>
        <div class="container">
            ${errormsg}
           ${errormsg=null}
            <article>  
                <fieldset class="cadastro"> 
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Inserir informações de clientes</legend>
                        <label>Inserir nome completo: </label><p><input type="text" name="nomecliente" /></p>
                        <label>Inserir email: </label><p><input type="email" name="email" /></p>
                        <label>Inserir data de aniversário:</label><p><input type="text" name="aniversario" placeholder="dd/mm/aaaa" maxlength="10" OnKeyPress="formatar('##/##/####', this)" /></p>
                        <label>Inserir CPF:</label><p><input type="text" name="cpf" placeholder="000.000.000-00" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" required="required" />*</p>
                        <input type="hidden" name="command" value="InfoCliente" />   
                        <input type="hidden" name="action" value="insere.confirma" />
                        <p><input type="submit" value="Inserir" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
