package models;

public class Coordenador extends Funcionario {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n\tCoordenador { cpf = ")
                .append(this.getCpf())
                .append(", nome = ")
                .append(this.getNome())
                .append(", salário = ")
                .append(this.getSalario())
                .append(" }\n");

        return stringBuilder.toString();
    }
}
