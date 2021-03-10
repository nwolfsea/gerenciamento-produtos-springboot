package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public static List<Cliente> getClientes
            () {
        return clientes;
    }

    public Cliente pesquisarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        throw new RuntimeException("CPF não cadastrado!");
    }


}
