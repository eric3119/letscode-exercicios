package models;

public class GerenteProjeto extends Funcionario {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n\tGerenteProjeto { cpf = ")
                .append(this.getCpf())
                .append(", nome = ")
                .append(this.getNome())
                .append(", salário = ")
                .append(this.getSalario())
                .append(" }");

        return stringBuilder.toString();
    }
}
