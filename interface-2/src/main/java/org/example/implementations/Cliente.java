package org.example.implementations;

import java.time.LocalDate;

import org.example.formatters.PTBRDateFormatter;

public class Cliente {
    public enum Sexo {
        MASCULINO, FEMININO
    };

    String nome;
    Sexo sexo;
    LocalDate dataNascimento;

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public Cliente setSexo(Sexo sexo) {
        this.sexo = sexo;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Cliente setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    @Override
    public String toString() {
        return "Cliente [dataNascimento=" + PTBRDateFormatter.format(dataNascimento) + ", nome=" + nome + ", sexo=" + sexo + "]";
    }

    

}
