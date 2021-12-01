package livraria.negocio;

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

import java.util.Iterator;

import java.util.List;

import livraria.negocio.excecoes.CompraException;

import livraria.negocio.excecoes.LivroNaoEncontradoException;


public class Livraria {

    private List<Livro> estoqueLivros;

    public Livraria(){

        estoqueLivros = new ArrayList<Livro>();

        popularLivros();

    }

    private void popularLivros(){

        Livro livro = new Livro();

        livro.setIdLivro("001");

        livro.setAno(2008);

        livro.setTitulo("Head First Servlets and JSP");

        livro.setDescricao("Livro sobre Servlets e JSP");

        livro.setAutores("Bryan Basham, Kathy Sierra, Bert Bates");

        livro.setQuantidade(10);

        livro.setPreco(200.5);

        estoqueLivros.add(livro);

        Livro lirvo2 = new Livro();
        
        livro2.setIdLivro("002");

        livro2.setAno(2018);

        livro2.setTitulo("Core Java Volume I--fundamentals (11th Edition)");

        livro2.setDescricao("Livro sobre fundamentações java para progamadores focados (Idioma: Inglês)");

        livro2.setAutores("Cay S. Horstmann");

        livro2.setQuantidade(22);

        livro2.setPreco(898.9);

        estoqueLivros.add(livro2);

        Livro lirvo3 = new Livro();
        
        livro3.setIdLivro("003");

        livro3.setAno(2017);

        livro3.setTitulo("Deep Learning Con Python");

        livro3.setDescricao("Livro sobre Deep Learning usando a linguagem python e a livraria 'Keras' (Idioma: Espanhol)");

        livro3.setAutores("François Chollet");

        livro3.setQuantidade(5);

        livro3.setPreco(662.2);

        estoqueLivros.add(livro3);

    }

    public List<Livro> getLivros(){

        return Collections.unmodifiableList(estoqueLivros);

    }

    public Livro getLivro(String idLivro) throws LivroNaoEncontradoException{

        Livro livroProcurado = null;

        for(Livro book : estoqueLivros){

            if(book.getIdLivro().equals(idLivro)){

                livroProcurado = book;

            }

            if (livroProcurado == null){

                throw new LivroNaoEncontradoException(
                        "Não foi possivel encontrar o livro: " + idLivro);
            }
        }

        return livroProcurado;
    }

    public void comprarLivros(CarrinhoCompras carrinho) throws CompraException{

        Collection<ItemCompra> items = carrinho.getItens();

        Iterator<ItemCompra> i = items.iterator();

        while(i.hasNext()){

            ItemCompra item = (ItemCompra) i.next();

            Livro livro = (Livro) item.getItem();

            String id = livro.getIdLivro();

            int quantity = item.getQuantidade();

            comprarLivro(id, quantity);

        }
    }

    public void comprarLivro(String idLivro, int qtdComprada) throws CompraException {

        Livro livroSelecionado;

        try{

            livroSelecionado = getLivro(idLivro);

        }
        catch (LivroNaoEncontradoException e){

            throw new CompraException(e.getMessage());
        }

        int qtdEstoque = livroSelecionado.getQuantidade();

        if((qtdEstoque - qtdComprada) >= 0) {

            int novaQtd = qtdEstoque - qtdComprada;

            livroSelecionado.setQuantidade(novaQtd);
        }
        else{
            throw new CompraException("Livro" + idLivro + "sem estoque suficiente.");
        }
    }

    public void fechar(){
        // Liberaria conexões de banco de dados, se usasse.
    }
}
