package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Exceptions.ProdutoNaoEncontradoException;
import br.com.zup.Produtos.Exceptions.ProdutoRepetidoException;
import br.com.zup.Produtos.Models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    /**
     * Adiciona produto para o cliente
     * @param produto
     * @return
     */
    public Produto adicionarProduto(Produto produto) {
        try {
            pesquisarProduto(produto.getNome());
        } catch (ProdutoNaoEncontradoException erro) {
            produtos.add(produto);
            return produto;
        }
        throw new ProdutoRepetidoException("Produto repetido!");
    }


    /**
     * Pesquisa produto para o cliente
     * @param nome
     * @return
     */
    public Produto pesquisarProduto(String nome) {
        for (Produto produto : produtos) {
            if (nome.equals(produto.getNome())) {
                return produto;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encontrado!");
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Mostra produto para o cliente
     * @return
     */
    public List<Produto> mostrarProdutos() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new RuntimeException("Não existe produto cadastrado!");
    }
}
