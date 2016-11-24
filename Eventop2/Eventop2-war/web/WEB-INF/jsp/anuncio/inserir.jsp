<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Anuncios</title>
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
                    ${sucessmsg}
                    ${sucessmsg=null}
                    ${errormsg}
                    ${errormsg=null}
                    <form action="FrontController" method="POST" id="cadastro">
                        <legend>Inserir Anuncio</legend>
                        <label>Inserir anuncio: </label>
                        <p><select name="tpAnuncio">
                                <option value="">-- Selecione o tipo do anúncio --</option>
                                <option value="Buffet de Casamento">Buffet de Casamento</option>
                                <option value="Debutante">Debutante</option>
                                <option value="Festas infantis">Festas infantis</option>
                                <option value="Outros">Outros</option>
                            </select></p>
                        <label>Descreve seus Serviços</label>
                        <p><textarea class="form-control" rows="5" name="descricao" placeholder="Digite seu texto"></textarea></p>
                        <input type="hidden" name="fkuser" value="${username.idusuariocliente}" />   
                        <input type="hidden" name="command" value="Anuncio"/>   
                        <input type="hidden" name="action" value="insere.confirma" />
                        <p><input type="submit" value="Inserir" /></p>
                    </form>
                </fieldset>
            </article>
        </div>
    </body>
</html>
