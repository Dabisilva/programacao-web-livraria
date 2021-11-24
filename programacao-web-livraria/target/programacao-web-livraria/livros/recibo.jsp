<%@ include file="/cabecalho.jsp" %>

<h3>Obrigado ${param.nome}.</h3>
<br />

<jsp:useBean id="now" class="java.util.Date" />

<jsp:setProperty name="now" property="time" value="${now.time+432000000}" />

​ Seus livros serão enviados paravocê em

<fmt:formatDate value="${now}" type="date" dateStyle="full" />.<br /><br />

<c:remove var="cart" scope="session" />

<c:url var="url" value="/livraria.jsp" />

<strong>
  <a href="${url}">Continuar comprando</a>
</strong>
Valor total da compra: <%@ include file="/rodape.jsp" %>
