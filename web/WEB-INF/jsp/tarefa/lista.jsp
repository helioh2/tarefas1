<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <script type="text/javascript" src="resources/js/jquery-3.0.0.js"></script>
    </head>
<body>
    <a href="logout">Sair do sistema</a>
  
  <a href="novaTarefa">Criar nova tarefa</a> 

  <br /> <br />        

  <table>
  <tr>
    <th>Id</th>
    <th>Descrição</th>
    <th>Finalizado?</th>
    <th>Data de finalização</th>
  </tr>
  <c:forEach items="${tarefas}" var="tarefa">
    <tr id="tarefa_${tarefa.id}">
      <td>${tarefa.id}</td>
      <td>${tarefa.descricao}</td>
      <c:if test="${tarefa.finalizado eq false}">
          
          <td id="tarefafinalizada_${tarefa.id}">
              <a href="#" onclick="finalizarAgora(${tarefa.id})">
                  Finalizar agora! </a></td>
      
      </c:if>
      <c:if test="${tarefa.finalizado eq true}">
        <td>Finalizado</td>
      </c:if>
      <td id="datatarefa_${tarefa.id}">
        <fmt:formatDate 
          value="${tarefa.dataFinalizacao.time}" 
          pattern="dd/MM/yyyy"/>
      </td>
      <td><a href="removerTarefa?id=${tarefa.id}">Remover</a></td>
      <td><a href="mostraTarefa?id=${tarefa.id}">Alterar</a></td>
    </tr>
  </c:forEach>
  </table>
  
  <script type="text/javascript">
      function finalizarAgora(id) {
          $.post("finalizarTarefa", {'id':id}, function(dadosDeResposta) {
              $("#tarefa_"+id).html(dadosDeResposta);
              
          });
      }
  </script>    
</body>
</html>