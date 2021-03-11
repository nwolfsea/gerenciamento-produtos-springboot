package br.com.zup.Produtos.DTO;


import javax.validation.constraints.NotEmpty;


    public class ProdutoDTO {
        @NotEmpty
        private String nome;

        public ProdutoDTO() {
        }

        public ProdutoDTO(String nomeDoProduto) {
            this.nome = nomeDoProduto;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

