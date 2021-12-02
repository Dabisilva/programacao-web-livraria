<%@ include file="/cabecalho.jsp" %>
<jsp:useBean id="livrariaBean" class="livraria.negocio.LivrariaBean" scope="page" >

      <jsp:setProperty name="livrariaBean" property="sistema" value="${sistemaLivraria}" />

</jsp:useBean>

<c:if test="${!empty param.idLivro}" id="detalhes-livro">

      <c:set var="id" value="${param.idLivro}"/>

            q<jsp:setProperty name="livrariaBean" property="idLivro" value="${id}" />

      <c:set var="livro" value="${livrariaBean.livro}" />

      <h2 id="title-component">${livro.titulo}</h2>

      Autoria de  <em> ${livro.autores}</em>

      (${livro.ano})<br> <br>

      <h4>Descrição</h4>

      <blockquote>${livro.descricao}</blockquote>

      <h4>Preço: <fmt:formatNumber value="${livro.preco}" type="currency"/></h4>

      <c:url var="url" value="/livros/catalogo" >

      <c:param name="Add" value="${id}" />

      </c:url>

      <p><strong><a href="${url}">Adicionar ao carrinho</a>     

</c:if>
<c:url var="url" value="/livros/catalogo" >

  <c:param name="Add" value="" />

</c:url>

<a href="${url}" id="continuar-comprando">Continuar comprando</a></strong></p>



<%@ include file="/rodape.jsp" %>