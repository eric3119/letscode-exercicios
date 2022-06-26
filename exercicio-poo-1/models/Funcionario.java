package models;

import java.math.BigDecimal;
import java.time.LocalDate;

import interfaces.ID;

public abstract class Funcionario implements BaseModel<String> {
    @ID
    String cpf;

    String nome;
    BigDecimal salario;
    LocalDate dataAdmissao;

    public String getNome() {
        return nome;
    }
    public Funcionario setNome(String nome) {
        this.nome = nome;
        return this;
    }
    public String getCpf() {
        return cpf;
    }
    public Funcionario setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }
    public BigDecimal getSalario() {
        return salario;
    }
    public Funcionario setSalario(BigDecimal salario) {
        this.salario = salario;
        return this;
    }
    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }
    public Funcionario setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
        return this;
    }
}
