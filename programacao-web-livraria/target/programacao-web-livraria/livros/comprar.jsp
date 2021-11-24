<%@ include file="/cabecalho.jsp" %>

<script>

  function comprar(){
    const form = document.getElementById("form");
    const nome = document.getElementById("nome");
    const cartao = document.getElementById("cardnum");

    if(nome.value == null || nome.value == ""){
        alert("Digite seu nome");

        return false;
    } else if(cartao.value == null || cartao.value == "" || cartao.value=="xxxx.xxxx.xxxx.xxxx") {
        alert("Digite o número do cartão");
        return false;
    } else form.submit();
  }

  function limparCartao(){
      const cartao = document.getElementById("cardnum");

      if(cartao.value == "xxxx.xxxx.xxxx.xxxx") cartao.value = "";
  }

    ​
</script>
<p>
  Valor total da compra: ​

  <strong
    ><fmt:formatNumber value="${sessionScope.cart.total}" type="currency"
  /></strong>
</p>

<p>
  Para efetuar a compra dos livros selecionados, informe os seguintes
  dados:<c:url var="url" value="/livros/recibo" />
</p>

<form id="form" action="${url}" method="post">
  <table summary="layout">
    <tr>
      <td><strong>Nome:</strong></td>

      <td><input type="text" name="nome" id="nome" value="" size="30" /></td>
    </tr>

    ​

    <tr>
      <td><strong>Número do cartão:</strong></td>

      <td>
        <input
          type="text"
          name="cardnum"
          id="cardnum"
          onfocus="limparCartao()"
          value="xxxx.xxxx.xxxx.xxxx"
          size="16"
        />
      </td>
    </tr>

    ​

    <tr>
      <td></td>

      <td><input type="button" onClick="comprar()" value="Comprar" /></td>
    </tr>

    ​
  </table>
</form>

<%@ include file="/rodape.jsp" %>
