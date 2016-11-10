<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        
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
        <script>
function alterna(doc) {

	if (doc == 1) {
	document.getElementById("tipo1").style.display = "block";
	document.getElementById("tipo2").style.display = "none";
	} else {
	document.getElementById("tipo1").style.display = "none";
	document.getElementById("tipo2").style.display = "block";
	}

}
</script>
        <title>Login EvenTOP</title>
    </head>

    <body>
        <div class="container center">
        <br />
        <br />
        <ul id="adajaxmenu" class="admenus">
                     <li><a href='/'><i class='fa fa-home fa-lg'></i></a></li>    
                    <li><a class="" href="FrontController?command=Usuario&action=index">EvenTOP</a></li>
                    <li class=""><a href="FrontController?command=Usuario&action=index">Home</a></li>
                    <li id="left"><a class="left" href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user" class="left"></span> Sign Up</a></li>
                    <li id="left2"><a class="left" href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in" class="left"></span> Login</a></li>
        </ul>
        <br />
        <br />
        <div class="container center" style="width: 700px;">
            ${errormsg}
            ${errormsg=null}
            ${sucessmsg}
            ${sucessmsg=null}
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#cliente">Cadastro Cliente</a></li>
                <li><a data-toggle="tab" href="#promoter">Cadastro Promoter</a></li>
                <li><a data-toggle="tab" href="#fornecedor">Cadastro Fornecedor</a></li>
            </ul>

            <div class="tab-content" style="background: #ccc;" >
                <div id="cliente" class="tab-pane fade in active" >
                    <form action="FrontController" method="POST" style="margin-left:200px;">
                        <br />
                        <br />
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nomecliente" required="required">
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome de Usuário</label>
                            <input type="text" class="form-control" id="nome" name="username" required="required">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="email@dominio.com" required="required">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" id="txtPass"  type="password" class="form-control" id="senha" name="senha1" placeholder="*********" required="required">
                        </div>
                        <div class="form-group">
                            <label for="conf-senha">Confirmar Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" type="password" class="form-control" id="txtConf-senha" name="senha2" placeholder="*********"required="required">
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone</label>
                            <input type="text" name="telefone" id="telefone" maxlength="13" placeholder="00 00000-0000" onkeypress="mascara(this, '## #####-####')"  class="form-control" required="required"/>

                        </div>

                        <div class="form-group">
                            <label for="cpf">CPF</label>
                            <input type="text" class="form-control" id="cpf" placeholder="000.000.000-00" onkeypress="mascara(this, '###.###.###-##')" name="cpf" maxlength="14" required="required">
                        </div>
                        <p type="text"  id="resultadoCadastro" style="font-weight:bold;"></p>
                        <input type="hidden" class="form-control" id="tipo" name="txtTipo" value="c">
                        <input type="hidden" name="command" value="Usuario" />
                        <input type="hidden" name="action" value="registrar" />    
                        <input type="submit" class="btn btn-default" name="btnSubmit" value="Cadastrar">

                    </form>
                </div>
                <div id="promoter" class="tab-pane fade">
                    <form action="FrontController" method="POST" style="margin-left:200px;">
                        <br />
                        <br />
                        <div class="form-group">
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nomePromoter" required="required" >
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome de Usuário</label>
                            <input type="text" class="form-control" id="nome" name="username" required="required">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="email@dominio.com" required="required">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" id="txtPass"  type="password" class="form-control" id="senha" name="senha1" placeholder="*********" required="required">
                        </div>
                        <div class="form-group">
                            <label for="conf-senha">Confirmar Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" type="password" class="form-control" id="txtConf-senha" name="senha2" placeholder="*********" required="required">
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" id="telefone" placeholder="00 00000-0000" onkeypress="mascara(this, '## #####-####')" name="telefone" maxlength="13" required="required">
                        </div>
                        <div class="form-group">
                            <label for="cpf">CPF</label> 
                            <input type ="radio" name="doc" id="cpf" value="1"  onclick="alterna(this.value);"/> 
                        </div>
                        <div class="form-group" id="tipo1" style="display:none;">
                            <input type="text" class="form-control" id="cpf" placeholder="000.000.000-00" onkeypress="mascara(this, '###.###.###-##')" name="cpf" maxlength="14" >
                        </div>
                        <div class="form-group">
                            <label for="cnpj">CNPJ</label>
                            <input type = "radio" name="doc" id="cnpj" value="2" onclick="alterna(this.value);"/> 
                        </div>
                         <div class="form-group" id="tipo2" style="display:none;">
                            <input type="text" class="form-control" id="cnpj" placeholder="00.000.000/0000-00" onkeypress="mascara(this, '##.###.###/#### ##')" name="cnpj" maxlength="18">
                        </div>
                        <input type="hidden" class="form-control" id="tipo" name="txtTipo" value="p">
                        <input type="hidden" name="command" value="Usuario" />
                        <input type="hidden" name="action" value="registrar2" />
                        <input type="submit" class="btn btn-default" name="btnSubmit" value="Cadastrar">
                    </form>
                </div>
                <div id="fornecedor" class="tab-pane fade ">
                    <form action="FrontController" method="POST" style="margin-left:200px;">
                        <div class="form-group">
                            <br />
                            <br />
                            <label for="nome">Nome</label>
                            <input type="text" class="form-control" id="nome" name="nomeFornecedor" required="required" >
                        </div>
                        <div class="form-group">
                            <label for="nome">Nome de Usuário</label>
                            <input type="text" class="form-control" id="nome" name="username" required="required">
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="email@dominio.com" required="required">
                        </div>
                        <div class="form-group">
                            <label for="senha">Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" id="txtPass"  type="password" class="form-control" id="senha" name="senha1" placeholder="*********" required="required">
                        </div>
                        <div class="form-group">
                            <label for="conf-senha">Confirmar Senha</label>
                            <input onKeyUp="validarSenha('txtPass', 'txtConf-senha', 'resultadoCadastro');" type="password" class="form-control" id="txtConf-senha" name="senha2" placeholder="*********" required="required">
                        </div>
                        <div class="form-group">
                            <label for="telefone">Telefone</label>
                            <input type="text" class="form-control" id="telefone" placeholder="00 00000-0000" onkeypress="mascara(this, '## #####-####')" name="telefone" maxlength="13" required="required">
                        </div>

                        <div class="form-group">
                            <label for="cnpj">CNPJ</label>
                            <input type="text" class="form-control" id="cnpj" placeholder="00.000.000/0000-00" onkeypress="mascara(this, '##.###.###/#### ##')" name="cnpj" maxlength="18" required="required">
                        </div>
                        <input type="hidden" class="form-control" id="tipo" name="txtTipo" value="p">
                        <input type="hidden" name="command" value="Usuario" />
                        <input type="hidden" name="action" value="registrar3" />
                        <input type="submit" class="btn btn-default" name="btnSubmit" value="Cadastrar">
                    </form>
                </div>
            </div>
        </div>
            </div>
    </body>
</html>
