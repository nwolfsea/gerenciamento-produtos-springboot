package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto) {
        Produto resultadoPesquisa = pesquisarProduto(produto.getNome());
        if (resultadoPesquisa != null) {
            atualizarQuantidade(produto.getNome(), produto.getQuantidade());
        } else {
            produtos.add(produto);
        }
        return produto;
    }

    private Produto pesquisarProduto(String nome) {
        for (Produto produto : produtos) {
            if (nome.equals(produto.getNome())) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(nome)) {
                produtos.set(i, produtos.get(i).adicionarQuantidade(quantidade));
            }
        }
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public List<Produto> mostrarProdutos() {
        if (produtos.size() > 0) {
            return produtos;
        }
        throw new RuntimeException("Não existe produto cadastrado!");
    }
}
