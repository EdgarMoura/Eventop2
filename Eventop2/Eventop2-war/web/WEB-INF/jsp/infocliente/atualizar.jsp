<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar informações de clientes</title>
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
        <script>
            function mascara(t, mask) {
                var i = t.value.length;
                var saida = mask.substring(1, 0);
                var texto = mask.substring(i);
                if (texto.substring(0, 1) != saida) {
                    t.value += texto.substring(0, 1);
                }
            }
        </script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>

        <div class="container">
            ${errormsg}
            ${errormsg=null}
            <h3>Alterar informações de clientes</h3>          
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>NOME COMPLETO</td> 
                        <td>EMAIL</td> 
                        <td>TELEFONE</td> 


                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${infoClientes}" var="infoCliente">
                        <tr>
                            <td>${infoCliente.idinfocliente}</td>
                            <td>${infoCliente.nomecliente}</td>
                            <td>${infoCliente.email}</td>
                            <td>${infoCliente.telefone}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="container">
            <article>  
                <fieldset class="cadastro"> 

                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Alterar informações de clientes</legend>
                        <label>Informações de clientes: </label> 
                        <p><select name="infoClientes">
                                <option value="">-- Selecione o nome completo --</option>
                                <c:forEach items="${infoClientes}" var="infoCliente">
                                    <option value="${infoCliente.idinfocliente}">${infoCliente.nomecliente}</option>
                                </c:forEach> 
                            </select></p>
                        <label>Novo nome completo:</label> <p><input type="text" name="nomecliente" required="required"/></p>
                        <label>Alterar email:</label> <p><input type="email" name="email" required="required" /></p>
                        <label>Alterar telefone:</label><p><input type="text" name="telefone" placeholder="00 00000-0000" onkeypress="mascara(this, '## #####-####')" maxlength="13" required="required" /></p>
                        <input type="hidden" name="command" value="InfoCliente" />
                        <input type="hidden" name="action" value="atualiza.confirma" />
                        <p><input type="submit" value="Alterar" /></p>
                    </form>
                    </div>
                    </body>
                    </html>
