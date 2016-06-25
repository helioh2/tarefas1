<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:formatDate 
         value="${tarefa.dataFinalizacao.time}" 
         pattern="dd/MM/yyyy"/>