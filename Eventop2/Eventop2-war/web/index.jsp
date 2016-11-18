<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>Eventop</title>
        <meta charset="utf-8">
        <link href="css/menuCss.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="css/cssIndex.css" rel="stylesheet" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        <c:if test="${infoClientes==null}">
            <c:redirect url="FrontController?command=Usuario&action=index"></c:redirect>
            
        </c:if>      
        <div class="container center">
        <div class="jumbotron text-center">
            <h1>Seja Bem Vindo, ao EvenTop</h1>
            <p> Os melhores eventos estão aqui!!!</p>   
        </div>
       <ul id="adajaxmenu" class="admenus">
                     <li><a href='/'><i class='fa fa-home fa-lg'></i></a></li>    
                    <li><a class="" href="FrontController?command=Usuario&action=index">EvenTOP</a></li>
                    <li class=""><a href="FrontController?command=Usuario&action=index">Home</a></li>
                    <li id="left"><a class="left" href="FrontController?command=Usuario&action=cadastrar"><span class="glyphicon glyphicon-user" class="left"></span> Sign Up</a></li>
                    <li id="left2"><a class="left" href="FrontController?command=Usuario&action=entrar"><span class="glyphicon glyphicon-log-in" class="left"></span> Login</a></li>
        </ul>
        <main>
            <c:forEach items="${infoClientes}" var="infoCliente">
                <c:if test="${infoCliente.getUsuarioCliente().getAnuncioList().isEmpty() == false}">
                    <c:forEach begin="0" end="${infoCliente.getUsuarioCliente().getAnuncioList().size() - 1}" varStatus="i" var="items">  
                    <section>
                        <label>Dados do Promoter</label>
                        <p>Nome: ${infoCliente.nomecliente}</p>
                        <p>Email: ${infoCliente.email}</p>
                        <p>Telefone: ${infoCliente.telefone}<p>
                            <label>Anúncios do promoter </label>
                        
                            <p>ID Anúncio: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getIdAnuncio()} </p>
                            <p>Tipo do Anúncio: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getTipoAnuncio()} </p>
                            <p>Descrição: ${infoCliente.getUsuarioCliente().getAnuncioList().get(i.index).getDescricao()} </p>
                            </section>
                        </c:forEach>
                    
                </c:if>
            </c:forEach>
            ${infoClientes=null }
        </main> 
        </div>
         
    </body>
   
</html>

