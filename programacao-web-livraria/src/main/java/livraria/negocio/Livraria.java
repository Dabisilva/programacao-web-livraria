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

        Livro lirvo4 = new Livro();
        
        livro4.setIdLivro("004");

        livro4.setAno(2008);

        livro4.setTitulo("Clean Code: A Handbook of Agile Software Craftsmanship");

        livro4.setDescricao("Um livro de insights de code cleaning e desenvolvimento de software(Idioma: Inglês)");

        livro4.setAutores("Robert C. Martin");

        livro4.setQuantidade(12);

        livro4.setPreco(202.7);

        estoqueLivros.add(livro4);

        Livro lirvo5 = new Livro();
        
        livro5.setIdLivro("005");

        livro5.setAno(2009);

        livro5.setTitulo("Introduction to Algorithms");

        livro5.setDescricao("Um livro de estudo rigoroso porém compreensível sobre algorítimos(Idioma: Inglês)");

        livro5.setAutores("Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein");

        livro5.setQuantidade(3);

        livro5.setPreco(540.4);

        estoqueLivros.add(livro5);

        Livro lirvo6 = new Livro();
        
        livro6.setIdLivro("006");

        livro6.setAno(1996);

        livro6.setTitulo("Structure and Interpretation of Computer Programs");

        livro6.setDescricao("Um dos melhores livros para se estudar os fundamentos da programação (Idioma: Inglês)");

        livro6.setAutores("Harold Abelson, Gerald Jay Sussman, Julie Sussman");

        livro6.setQuantidade(14);

        livro6.setPreco(469.7);

        estoqueLivros.add(livro6);

        Livro lirvo7 = new Livro();
        
        livro7.setIdLivro("007");

        livro7.setAno(2017);

        livro7.setTitulo("Code Complete");

        livro7.setDescricao("Considerado um dos melhores guias de programação, com mais de uma década ajudando programadores (Idioma: Inglês)");

        livro7.setAutores("Steve McConnell");

        livro7.setQuantidade(31);

        livro7.setPreco(379.8);

        estoqueLivros.add(livro7);

        Livro lirvo8 = new Livro();
        
        livro8.setIdLivro("008");

        livro8.setAno(2019);

        livro8.setTitulo("The Pragmatic Programmer: Your Journey to Mastery, 20th Anniversary Edition");

        livro8.setDescricao("Um livro que te ajuda a ver a essência do desenvolvimento de software, independente de qualquer linguagem, uma verdadeira obra de arte. (Idioma: Inglês)");

        livro8.setAutores("Andrew Hunt, David Thomas");

        livro8.setQuantidade(2);

        livro8.setPreco(311.2);

        estoqueLivros.add(livro8);


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
