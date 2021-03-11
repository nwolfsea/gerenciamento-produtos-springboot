package br.com.zup.Produtos.Services;

import br.com.zup.Produtos.Exceptions.CPFRepetidoException;
import br.com.zup.Produtos.Exceptions.EmailRepetidoException;
import br.com.zup.Produtos.Models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private static List<Cliente> clientes = new ArrayList<>();

    public void adicionarCliente(Cliente cliente){
        verificaSeClienteExiste(cliente.getCpf(), cliente.getEmail());
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

    public Cliente pesquisarClientePorEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(email)) {
                return cliente;
            }
        }
        throw new RuntimeException("CPF não cadastrado!");
    }

    public void verificaSeClienteExiste(String cpf, String email){
        for (Cliente  cliente : clientes){
            if(cliente.getCpf().equals(cpf) ){
                throw new CPFRepetidoException();
            }
            if(cliente.getEmail().equalsIgnoreCase(email)){
                throw new EmailRepetidoException();
            }
        }
    }


}
