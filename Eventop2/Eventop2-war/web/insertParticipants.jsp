<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir Participante</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="userAdmin/jsp/menu.jspf" %>
    
       
        <div class="container">
            ${sucessmsg}
            ${sucessmsg=null}
            <h3>Inserir Participante </h3>
            <article>  
                <fieldset class="cadastro">
                    <form action="FrontController"  method="POST" id="cadastro" >
                        <input type="hidden" name="id" value="${username.idUserevent}" /> 
                        <label>Evento:</label> 
                        <p><select name="events">
                                <option value="">-- Selecione o evento --</option>
                                <c:forEach items="${events}" var="event">
                                    <option value="${event.idEvent}">${event.nameEvent}</option>
                                </c:forEach>
                            </select></p>
                        <input type="hidden" name="command" value="Participant" />
                        <input type="hidden" name="action" value="insert.participant" />
                        <p><input type="submit" value="Inserir" /></p>
                    </form>
                </fieldset>     
            </article>          
        </div>
    </body>
</html>

