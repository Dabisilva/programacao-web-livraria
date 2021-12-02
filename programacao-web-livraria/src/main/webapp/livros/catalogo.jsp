<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="/cabecalho.jsp" %>

<jsp:useBean id="livrariaBean" class="livraria.negocio.LivrariaBean" scope="page" >

   <jsp:setProperty name="livrariaBean" property="sistema" value="${sistemaLivraria}" />

</jsp:useBean>
<c:if test="${not empty param.Add}">
  
      <c:set var="idL" value="${param.Add}"/>

      <jsp:setProperty name="livrariaBean" property="idLivro" value="${idL}" />
 
      <c:set var="livroAdicionado" value="${livrariaBean.livro}" />
   
      <h3 id="title-catalago">
         Você adicionou o livro <em>${livroAdicionado.titulo}</em> ao seu carrinho de compras.
      </h3>
   
</c:if>
   
<c:choose>

    <c:when test="sessionScope.cart.numeroItens > 0">

       <c:url var="url" value="/livros/mostrarCarrinho">

          <c:param name="limpar" value="0"/>

          <c:param name="remover" value="0"/>

       </c:url>

       <p>

         <a href="${url}">Ver carrinho de compras</a>

          <c:url var="url" value="/livros/comprar" />

           <a href="${url}">Finalizar compras</a></strong>

        </p>

    </c:when>

    <c:otherwise>
         Seu carrinho de compras está vazio.
    </c:otherwise>

</c:choose> 

<br>

<br>

<h3 id="title-component">Livros disponíveis para compra:</h3>

<div>

 <table summary="layout">

  <c:forEach var="livro" begin="0" items="${livrariaBean.livros}">

    <tr>

      <c:set var="idLivro" value="${livro.idLivro}" />

      <td background-color="#ffffaa">

        <c:url var="url" value="/livros/detalhesLivro" >

           <c:param name="idLivro" value="${idLivro}"/>

        </c:url>

        <a href="${url}"><strong>${livro.titulo}</strong></a>

      </td>

         <td background-color="#ffffaa" rowspan=2>

         <fmt:formatNumber value="${livro.preco}" type="currency"/>

         </td>

         <td background-color="#ffffaa" rowspan=2>

            <c:url var="url" value="/livros/catalogo" >

               <c:param name="Add" value="${idLivro}"/>

               </c:url>

               <a href="${url}">Adicionar livro ao carrinho</a>

         </td>

          </tr>

   <tr>

     <td background-color="#ffffff">

          <em>${livro.autores} </em>

     </td>

   </tr>

  </c:forEach>

 </table>

</div>
   <c:if test="${not empty param.Add}">

   <c:set var="idL" value="${param.Add}"/>

   <jsp:setProperty name="livrariaBean" property="idLivro" value="${idL}" />

   <c:set var="livroAdicionado" value="${livrariaBean.livro}" />

   <h3>

      <span>Você adicionou o livro <em>${livroAdicionado.titulo}</em> ao seu carrinho de compras.</span>

   </h3>

</c:if>
<%@ include file="/rodape.jsp" %>
