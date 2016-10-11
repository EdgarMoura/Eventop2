
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <meta name="viewport" content="width=500, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <meta charset="utf-8" />
        <title>
            Bem-vindo a Eventop
        </title>
        <link href="css/cssLogin.css" rel="stylesheet" type="text/css"/>
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
        <section class="flutuante"	>
            <header id="cabecalho">
                <h1>

                    Bem-vindo a Eventop
                </h1>
            </header>
            <br />

            <article>
                <h2>
                    Soluções em promoções de festa!!!
                </h2> 
            </article>
        </section>
        <section class="flutuante">

            <form name="form" id="formulario1" action="FrontController"  method="POST">
                <span><b>Digite o seu login para entrar</b></span>
                <p><input type="text" name="username" placeholder="Seu Login *" value="${cookie.usernameCookie.value}" /></p>
                <p><input type="password" name="senha" placeholder="Sua Senha *" value="${cookie.passwordCookie.value}" /></p>
                <p><input type="checkbox" name="on" checked="checked"><b> Mantenha-me conectado</b></p>
                <p><input type="submit" value="Acessar"></p>
                <input type="hidden" name="command" value="Login" />
                <input type="hidden" name="action" value="login" />
                <input type="hidden" name="action2" value="visualizar2" />
               

            </form>
            ${errormsg}
            ${errormsg=null}
             ${sucessmsg}
             ${sucessmsg=null}
            <br/>
            <form name="form" id="formulario2" action="FrontController" method="POST">
                <span><b>Novo na Eventop? Inscreva-se</b></span></br>
                <hr>
                <p><input type="text" name="nomecliente" placeholder="Nome Completo" required="required" />*</p>
                <p><input type="text" name="username" placeholder="Username" required="required" />*</p>
                <p><input type="password" name="senha1" placeholder="Senha" required="required" />*</p>
                <p><input type="password" name="senha2" placeholder="Confirme sua Senha" required="required" />*</p>
                <p><input type="email" name="email" placeholder="Email" required="required" />*</p>
                <b><span>CPF:</span></b>
                <p><input type="text" name="cpf" placeholder="000.000.000-00" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" required="required" />*</p>
                <b><span>Aniversário:</span></b>
                <p><input type="text" name="aniversario" placeholder="dd/mm/aaaa" maxlength="10" OnKeyPress="formatar('##/##/####', this)"required="required" /> *</p>
                <input type="hidden" name="command" value="Login" />
                <input type="hidden" name="action" value="registrar" />
                <p><input type="submit" value="Cadastrar" /></p>				
            </form>
            ${sucessmsg}
            ${sucessmsg=null}
        </section>

        <footer>
            <hr/>
            <small>&copy2016;Edgar</small>

        </footer>
    </body>

</html>