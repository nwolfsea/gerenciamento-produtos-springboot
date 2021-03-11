package br.com.zup.Produtos.Controllers;

import br.com.zup.Produtos.DTO.ComprasDTO;
import br.com.zup.Produtos.DTO.ProdutoDTO;
import br.com.zup.Produtos.Models.Compras;
import br.com.zup.Produtos.Services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("compras/")
public class ComprasController {

    @Autowired
    ComprasService comprasService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComprasDTO adicionarCompra(@RequestBody @Valid ComprasDTO compras) {
        ComprasDTO resultado = new ComprasDTO();
        resultado.setCpf(compras.getCpf());
        resultado.setProdutos(new ArrayList<ProdutoDTO>());

        for (ProdutoDTO produto : compras.getProdutos()) {
            Compras compra = comprasService.adicionarCompra(compras.getCpf(), produto.getNome());
            resultado.getProdutos().add(new ProdutoDTO(produto.getNome()));
        }

        return resultado;

    }
    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Compras> listarCompras() {
        return comprasService.getCompras();
    }

    @GetMapping("{cpf}/")
    public List <Compras> listarComprasDoCliente(@PathVariable String cpf) {
        return comprasService.listarComprasDoCliente(cpf);
    }
}