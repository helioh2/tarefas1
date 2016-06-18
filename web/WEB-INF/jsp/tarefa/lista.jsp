<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
    <head>
        <script type="text/javascript" src="resources/js/jquery-3.0.0.js"></script>
    </head>
<body>
  
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
    <tr>
      <td>${tarefa.id}</td>
      <td>${tarefa.descricao}</td>
      <c:if test="${tarefa.finalizado eq false}">
          
          <td id="tarefa_${tarefa.id}">
              <a href="#" onclick="finalizarAgora(${tarefa.id})">
                  Finalizar agora! </a></td>
      
      </c:if>
      <c:if test="${tarefa.finalizado eq true}">
        <td>Finalizado</td>
      </c:if>
      <td>
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
          $.get("finalizarTarefa?id="+id, function(dadosDeResposta) {
              alert("Tarefa finalizada!");
              //$("#tarefa_"+id).html("Finalizado!");
              document.getElementById("tarefa_"+id).innerHTML = "Finalizado!";
          });
      }
  </script>    
</body>
</html>