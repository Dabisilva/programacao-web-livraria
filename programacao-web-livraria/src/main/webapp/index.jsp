<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ include
file="/cabecalho.jsp" %>

<div>
  <p><b>Livraria Online</b></p>

  <c:url var="url" value="/livros/catalogo" />

  <p>
    <b><a href="${url}?Add=">Iniciar compras</a></b>

    <br />
  </p>
</div>
<%@ include file="/rodape.jsp" %>
