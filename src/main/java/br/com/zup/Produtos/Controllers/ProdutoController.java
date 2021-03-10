package br.com.zup.Produtos.Controllers;

import br.com.zup.Produtos.Models.Produto;
import br.com.zup.Produtos.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarProduto (@RequestBody Produto produto){
        produtoService.adicionarProduto(produto);
    }

}

