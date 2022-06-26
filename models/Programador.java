package models;

import java.math.BigDecimal;

import interfaces.BonusSalario;

public class Programador extends Funcionario implements BonusSalario {

    private BigDecimal bonificacao = BigDecimal.valueOf(1000);

    @Override
    public BigDecimal getBonificacao() {
        return this.bonificacao;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n\tProgramador { cpf = ")
                .append(this.getCpf())
                .append(", nome = ")
                .append(this.getNome())
                .append(", salário = ")
                .append(this.getSalario())
                .append(", bonificação = ")
                .append(this.getBonificacao())
                .append(" }");

        return stringBuilder.toString();
    }

}
