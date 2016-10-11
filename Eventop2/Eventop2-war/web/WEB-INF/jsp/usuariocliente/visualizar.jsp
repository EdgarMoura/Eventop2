<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar usuário do evento</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="../menu.jspf" %>
        ${returnMsg}
        ${returnMsg=null}
        <div class="container">
            <h3>Visualizar usuários dos eventos</h3>        
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>USERNAME</td> 
                        <td>PASSWORD</td> 
                        <td>FK_USERTYPE</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${userEvents}" var="userEvent">
                        <tr>
                            <td>${userEvent.idUserevent}</td>
                            <td>${userEvent.username}</td>
                            <td>${userEvent.password}</td>
                            <td>${userEvent.fkUsertype}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
