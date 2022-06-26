import java.math.BigDecimal;
import java.time.LocalDate;

import models.Coordenador;
import models.Funcionario;
import models.GerenteProjeto;
import models.Programador;
import repository.FuncionarioRepository;

public class Main {
    private final static FuncionarioRepository funcionarioRepository = FuncionarioRepository.getInstance();

    public static void main(String[] args) {

        Funcionario f1 = new Programador()
                .setCpf("00000000000")
                .setNome("Funcionário Programador")
                .setSalario(BigDecimal.valueOf(123))
                .setDataAdmissao(LocalDate.now());

        Funcionario f2 = new GerenteProjeto()
                .setCpf("00000000001")
                .setNome("Funcionário Gerente")
                .setSalario(BigDecimal.valueOf(456))
                .setDataAdmissao(LocalDate.now());

        Funcionario f3 = new Coordenador()
                .setCpf("00000000002")
                .setNome("Funcionário Coordenador")
                .setSalario(BigDecimal.valueOf(789))
                .setDataAdmissao(LocalDate.now());

        funcionarioRepository.save(f1);
        funcionarioRepository.save(f2);
        funcionarioRepository.save(f3);

        System.out.println(funcionarioRepository.getAll());

        System.out.println("Salário Funcionario 1 = "
                .concat(funcionarioRepository.calculaSalario("00000000000").toString()));

        System.out.println("Somatório Salários = "
                .concat(funcionarioRepository.getAll().stream()
                        .map(funcionario -> funcionarioRepository.calculaSalario(funcionario.getCpf()))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)
                        .toString()));

    }
}