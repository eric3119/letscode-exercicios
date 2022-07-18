package org.example;

public class Pessoa {
    private String nome;
        private String dataNascimento;

        public String getNome() {
            return nome;
        }

        public Pessoa setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public String getDataNascimento() {
            return dataNascimento;
        }

        public Pessoa setDataNascimento(String dataNascimento) {
            this.dataNascimento = dataNascimento;
            return this;
        }
}
