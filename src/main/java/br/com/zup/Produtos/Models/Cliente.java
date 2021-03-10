package br.com.zup.Produtos.Models;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Cliente {

 @NotNull(message = "O nome deve ser preenchido!")
 @NotEmpty(message = "O nome não deve ficar em branco!")
 private String nome;

 @NotNull(message = "O CPF deve ser preenchido!")
 @NotEmpty(message = "O CPF não deve ficar em branco!")
 @CPF(message = "O CPF informado é inválido!")
 private String cpf;

 @NotNull(message = "O email deve ser preenchido!")
 @NotEmpty(message = "O email não deve ficar em branco!")
 @Email(message = "O email informado é inválido!")
 private String email;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
