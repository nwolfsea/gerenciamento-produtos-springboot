package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    private static List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto){
        produtos.add(produto);
        return produto;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

}
