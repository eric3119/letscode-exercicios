package org.example;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private String cidade;
    private String uf;

    public String getNome() {
        return nome;
    }
    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public Pessoa setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }
    public String getCidade() {
        return cidade;
    }
    public Pessoa setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }
    public String getUf() {
        return uf;
    }
    public Pessoa setUf(String uf) {
        this.uf = uf;
        return this;
    }
    @Override
    public String toString() {
        return "Pessoa [cidade=" + cidade + ", dataNascimento=" + dataNascimento + ", nome=" + nome + ", uf=" + uf
                + "]";
    }

    
}
