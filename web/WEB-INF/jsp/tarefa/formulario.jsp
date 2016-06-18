<%-- 
    Document   : formulario
    Created on : 03/06/2016, 19:16:38
    Author     : CCE
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Adicionar tarefas</h3>
        <form action="adicionaTarefa" method="post">
            <input type="hidden" name="id" value="${tarefa.id}" />
            Descrição: <br />
            <textarea name="descricao" rows="5" cols="100"></textarea><br />
            <br>
            <form:errors path="tarefa.descricao" cssStyle="color:red"/>
            <br>    
            <input type="submit" value="Adicionar">
        </form>
    </body>
</html>
