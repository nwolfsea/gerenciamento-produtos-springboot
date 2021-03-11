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

    /**
     * Adiciona cliente na lista
     * @param cliente
     */
    public void adicionarCliente(Cliente cliente){
        verificaSeClienteExiste(cliente.getCpf(), cliente.getEmail());
        clientes.add(cliente);
    }

    public static List<Cliente> getClientes
            () {
        return clientes;
    }

    /**
     * Pesquisa cliente por CPF
     * @param cpf
     * @return
     */
    public Cliente pesquisarClientePorCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return cliente;
            }
        }
        throw new CPFRepetidoException("CPF repetido!");
    }

    /**
     * Pesquisa cliente por email
     * @param email
     * @return
     */
    public Cliente pesquisarClientePorEmail(String email) {
        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                return cliente;
            }
        }
        throw new EmailRepetidoException("Email repetido!");
    }

    /**
     * Verifica se o cliente existe utilizando cpf e email
     * @param cpf
     * @param email
     */
    public void verificaSeClienteExiste(String cpf, String email){
        for (Cliente  cliente : clientes){
            if(cliente.getCpf().equals(cpf) ){
                throw new CPFRepetidoException("CPF já cadastrado!");
            }
            if(cliente.getEmail().equalsIgnoreCase(email)){
                throw new EmailRepetidoException("Email já cadastrado!");
            }
        }
    }


}
