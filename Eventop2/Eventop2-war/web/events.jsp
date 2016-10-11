<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualizar Eventos</title>
        <link rel="icon" href="img/favicon.ico" />
        <link href="css/cssForm.css" rel="stylesheet" type="text/css"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%@include file="userAdmin/jsp/menu.jspf" %>
        
        ${returnMsg}
        ${returnMsg=null}
        <div class="container">
            <h3>Visualizar Eventos</h3>           
            <table class="table table-striped">
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>NOME DO EVENTO</td> 
                        <td>DATA DO EVENTO</td> 
                        <td>DESCRIÇAO DO EVENTO</td> 
                        <td>LOCAL DO EVENTO</td> 
                        <td>CIDADE DO EVENTO</td> 
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${events}" var="event">
                        <tr>
                            <td>${event.idEvent}</td>
                            <td>${event.nameEvent}</td>
                            <td>${event.dateevent}</td>
                            <td>${event.descriptionEvent}</td>
                            <td><a href="FrontController?command=Event&action=google&street=${event.venue}&cityName=${event.city}" >${event.venue}</a></td>
                            <td>${event.city}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
         <c:if test="${map!=null}">
            <iframe id="maps-frame" src="https://www.google.com/maps/embed/v1/place?q=${map.getFormatted_address()}$zoom=17&key=AIzaSyD7DHrjOYyUfu6dOqXUySFkZ8i8rb-TIBc">
            </iframe>
        </c:if>
        ${map=null}
        </div> 
    </body>
</html>
