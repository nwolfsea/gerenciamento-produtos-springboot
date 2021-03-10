package br.com.zup.Produtos.Controllers;

import br.com.zup.Produtos.Models.Cliente;
import br.com.zup.Produtos.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarCliente(@RequestBody @Valid Cliente cliente){
        clienteService.adicionarCliente(cliente);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Cliente> listarCliente(){
        return clienteService.getClientes();
    }

    @GetMapping("{cpf}/")
    @ResponseStatus(HttpStatus.OK)
    public Cliente pesquisarClientePorCpf(@PathVariable String cpf) {
        try {
            return clienteService.pesquisarClientePorCpf(cpf);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}


