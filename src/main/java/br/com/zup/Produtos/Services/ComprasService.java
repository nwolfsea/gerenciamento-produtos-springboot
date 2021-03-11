package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Exceptions.ProdutoEmFaltaException;
import br.com.zup.Produtos.Models.Cliente;
import br.com.zup.Produtos.Models.Compras;
import br.com.zup.Produtos.Models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    private List<Compras> compras;

    public ComprasService() {
        compras = new ArrayList<>();
    }


    public Compras adicionarCompra(String cpf, String nome) {
        Cliente cliente = clienteService.pesquisarClientePorCpf(cpf);
        Produto produto = produtoService.pesquisarProduto(nome);

        if (produto.getQuantidade() <= 0) {
            throw new ProdutoEmFaltaException(produto.getNome());
        }

        Compras compra = new Compras(cliente, Arrays.asList(produto));
        compras.add(compra);
        produto.setQuantidade(produto.getQuantidade() - 1);
        return compra;
    }

    public List<Compras> getCompras() {
        return compras;
    }

    public List<Compras> listarComprasDoCliente(String cpfDoCliente) {
        List<Compras> listaDeComprasDoCliente = new ArrayList<>();

        for (Compras compra : compras) {
            if (compra.getCliente().getCpf().equals(cpfDoCliente)) {
                listaDeComprasDoCliente.add(compra);
            }
        }

        return listaDeComprasDoCliente;

    }
}

