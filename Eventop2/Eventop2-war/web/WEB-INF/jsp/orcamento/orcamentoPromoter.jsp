<%-- 
    Document   : orcamentoPromoter
    Created on : 19/11/2016, 19:10:52
    Author     : Administrador
--%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Solicitar orçamento</title>
        <link href="css/orcamento.css" rel="stylesheet" type="text/css" />
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
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
        <table class="tabela">
            <tr class="topo">
                <td>Nome:</td>
                <td>Email</td>
                <td>Telefone</td>
                <td>Data:</td>
                <td>Período:</td>
                <td>Tema:</td>
                <td>Participantes</td>
                <td>Descrição:</td>

            </tr>
            <tr>
                <td>${solicitacao.nome}</td>
                <td>${solicitacao.email}</td>
                <td>${solicitacao.fkUsuarioCliente.infoCliente.telefone}</td>
                <td>${solicitacao.getDataEventoFormatted()}</td>
                <td>${solicitacao.periodo}</td>
                <td>${solicitacao.tema}</td>
                <td>${solicitacao.qtdPessoas}</td>
                <td>${solicitacao.descricao}</td>
            </tr>
        </table>  
        <br />
        <div class="center1"> 
            ${errormsg}
            ${errormsg=null}
            ${sucessmsg}
            ${sucessmsg=null}
            <h1 class="titulo">Enviar Orcamento</h1>


            <form action="FrontController" method="POST">
                <div class="servicos">
                    <section class="boxe2">
                        <h3 class="valor">Valor</h3>     
                        <input  type="text" name="vlPula"  placeholder="R$ - 00,00" min="100" max="10000" /><br />
                        <input type="text" name="vlCama" placeholder="R$ - 00,00" min="100" max="10000" /><br />
                        <input  type="text" name="vlpisc"  placeholder="R$ - 00,00" min="100" max="10000" /><br />
                    </section>
                    <section class="boxe">
                        <h3 class="brinq">Brinquedos</h3>
                        <input class="ck1" type="checkbox" name="pulapula" /> <span>Pula Pula</span><br />
                        <input class="ck2" type="checkbox" name="camaelastica" /><span> Cama Elastica</span><br />  
                        <input class="ck3" type="checkbox" name="pisciniabol" /><span>Piscina de Bolinha</span><br />
                    </section>     
                </div>

                <div class="dadosEnd"> 
                    <h3>Endereço</h3>
                    <section class="endereco1">           
                        <input  class="num" type="number" name="numero"  min="1" max="100000" placeholder="Digite o Numero" required="required" />
                        <input  type="text" class="cep" name="cep" placeholder="Cep - 00000-000" onkeypress="mascara(this, '#####-###')" maxlength="9" required="required" />

                        <select class="est" name="estado">
                            <option value="">-- Selecione o estado --</option>
                            <option value="São Paulo">São Paulo</option>
                            <option value="Paraíba">Paraíba</option>
                            <option value="Minas Gerais">Minas Gerais</option>
                            <option value="Rio de Janeiro">Rio de Janeiro</option>
                        </select>

                    </section> 
                    <section class="endereco">    
                        <input  type="text" name="logradouro" placeholder="Digite o Logradouro" required="required"/>
                        <input type="text" name="bairro" placeholder="Digite o Bairro" required="required"/>


                        <select class="cida" name="cidade">
                            <option value="">-- Selecione a cidade --</option>
                            <option value="Sao Paulo">São Paulo</option>
                            <option value="Guarulhos">Guarulhos</option>
                            <option value="Campinas">Campinas</option>
                            <option value="Ribeirao Preto">Ribeirão Preto</option>
                            <option value="Joao Pessoa">João Pessoa</option>
                            <option value="Sousa">Sousa</option>
                            <option value="Belo Horizonte">Belo Horizonte</option>
                            <option value="Juiz de Fora">Juiz de Fora</option>
                            <option value="Contagem">Contagem</option>
                            <option value="Rio de Janeiro">Rio de Janeiro</option>
                            <option value="Campos">Campos</option>
                            <option value="Buzios">Búzios</option>
                        </select>
                    </section>
                </div>   


                <section class="local">
                    <h3>Informações do Local</h3>
                    <input  class="valor" type="number" name="valor" placeholder="R$ - 00,00" min="1" max="10000" required="required">
                    <input  type="number" name="capacidade" placeholder="Capacidade" min="1" max="10000" required="required">
                    <textarea name="ambiente" placeholder="Descreva o Ambiente." rows="5" cols="65" ></textarea>
                    <h3>Descreva as informações do Cardapio</h3>
                    <textarea name="cardapio" rows="5" cols="65"></textarea>

                </section>
                <input class="enviar" type="submit" value="Enviar" />
                <input class="inf" type="hidden" name="command" value="Orcamento"/>   
                <input class="inf" type="hidden" name="action" value="enviarOrcamento" />  
                <input class="inf" type="hidden" name="idSolicitacao" value="${solicitacao.idSolicitacao}" /> 
                <input class="inf" type="hidden" name="idUsuarioCliente" value="${username.idusuariocliente}" />         
            </form>
        </div>  
        ${username.idusuariocliente}
    </body>
</html>
