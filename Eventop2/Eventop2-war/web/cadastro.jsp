<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <style>
            #fundo {background-image: url("img/aladim.gif");color: white;}
        </style>
        <script>
  function mascara(t, mask){
 var i = t.value.length;
 var saida = mask.substring(1,0);
 var texto = mask.substring(i);
 if (texto.substring(0,1) != saida){
 t.value += texto.substring(0,1);
 }
 }
        </script>
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
                    <a class="navbar-brand" href="FrontController?command=Usuario&action=index">EvenTOP</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="FrontController?command=Usuario&action=index">Home</a></li>
                        <li><a href="FrontController?command=Usuario&action=orcamento">Orçamento</a></li>
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

        <div class="container">
        ${errormsg}
        ${errormsg=null}
        ${sucessmsg}
        ${sucessmsg=null}
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#cliente">Cadastro Cliente</a></li>
                <li><a data-toggle="tab" href="#promoter">Cadastro Promoter</a></li>
                <li><a data-toggle="tab" href="#fornecedor">Cadastro Fornecedor</a></li>
            </ul>

            <div class="tab-content">
                <div id="home" class="tab-pane fade in active">
                    <form action="FrontController" method="POST" >
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
                    <form action="FrontController" method="POST" >
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
                            <label for="cnpj">CNPJ</label>
                            <input type="text" class="form-control" id="cnpj" placeholder="00.000.000/0000-00" onkeypress="mascara(this, '##.###.###/####-##')" name="cnpj" maxlength="18" required="required">
                        </div>
                        <p type="text"  id="resultadoCadastro" style="font-weight:bold;"></p>
                        <input type="hidden" class="form-control" id="tipo" name="txtTipo" value="p">
                        <input type="hidden" name="command" value="Usuario" />
                        <input type="hidden" name="action" value="registrar2" />
                        <input type="submit" class="btn btn-default" name="btnSubmit" value="Cadastrar">
                    </form>
                </div>
                <div id="Fornecedor" class="tab-pane fade">
                    <form action="FrontController" method="POST" >
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
                            <label for="cnpj">CNPJ</label>
                            <input type="text" class="form-control" id="cnpj" placeholder="xx xxxxxx/xxxx xx" onkeypress="mascara(this, '## ###.###/#### ##')" name="cnpj" maxlength="13" required="required">
                        </div>
                      
                        <p type="text"  id="resultadoCadastro" style="font-weight:bold;"></p>
                        <input type="hidden" class="form-control" id="tipo" name="txtTipo" value="p">
                        <input type="hidden" name="command" value="Usuario" />
                        <input type="hidden" name="action" value="registrar3" />
                        <input type="submit" class="btn btn-default" name="btnSubmit" value="Cadastrar">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
