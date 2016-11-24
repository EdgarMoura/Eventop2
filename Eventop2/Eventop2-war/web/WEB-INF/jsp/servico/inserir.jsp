<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Serviços</title>
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
        <%@include file="../menu.jspf"%>
        <a href=></a>
        <div class="container">

            <article> 

                <fieldset class="cadastro"> 
                    ${errormsg}
                    ${errormsg=null}
                    ${sucessmsg}
                    ${sucessmsg=null}
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Inserir Serviço</legend>
                        <label>Inserir serviço: </label>
                        <p><select name="tpServico">
                                <option value="" required="required">-- Selecione o tipo do serviço --</option>
                                <option value="Bebidas">Bebidas</option>
                                <option value="Brinquedos infantis">Brinquedos infantis</option>
                                <option value="Comidas">Comidas</option>
                                <option value="Decoração">Decoração</option>
                                <option value="Fotografia">Fotografia</option>
                                <option value="Entretenimento">Entretenimento</option>
                                <option value="Sonorização">Sonorização</option>
                                <option value="Outros">Outros</option>
                            </select></p>
                        <label>Descreve seus Serviços</label>
                        <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                        <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                        <input type="hidden" name="command" value="Servico"/>   
                        <input type="hidden" name="action" value="insere.confirma" />
                        <p><input type="submit" value="Inserir" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
