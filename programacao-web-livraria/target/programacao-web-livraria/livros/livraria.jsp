<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <%@ include
file="/cabecalho.jsp" %>

<p><b>Livraria Online</b></p>

<c:url var="url" value="/livros/catalogo" />

<p>
  <b><a href="${url}?Add=">Iniciar compras</a></b>

  <br />
</p>
<%@ include file="/rodape.jsp" %>
