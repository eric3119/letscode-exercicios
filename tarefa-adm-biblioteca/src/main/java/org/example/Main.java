package org.example;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;
import org.example.service.EmprestimoService;
import org.example.service.RealizarEmprestimoService;
import org.example.service.ValidadorEmprestimoCliente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

public class Main {

    private static EmprestimoService emprestimoService = EmprestimoService.getInstance();
    private static EmprestimoRepository emprestimoRepositoryTeste = EmprestimoRepository.getInstance();
    private static RealizarEmprestimoService realizarEmprestimoService = RealizarEmprestimoService.getInstance(
            List.of(new ValidadorEmprestimoCliente()));

    public static void main(String[] args) {
        Cliente c1 = new Cliente()
                .setEmail("teste@teste.com")
                .setNome("Teste")
                .setTelefone("999999999");
        Livro l1 = new Livro()
                .setTitulo("Titulo 1")
                .setMaximoDiarias(20L)
                .setCustoDiario(1.0);
        Livro l2 = new Livro()
                .setTitulo("Titulo 2")
                .setMaximoDiarias(20L)
                .setCustoDiario(.9);
        Livro l3 = new Livro()
                .setTitulo("Titulo 3")
                .setMaximoDiarias(20L)
                .setCustoDiario(.5);

        Emprestimo emprestimo = new Emprestimo()
                .setCliente(c1)
                .setLivro(l1)
                .setDataEmprestimo(LocalDateTime.of(LocalDate.of(2022, Month.APRIL, 1), LocalTime.now()));

        emprestimoRepositoryTeste.add(emprestimo);

        // realizarEmprestimoService.realizarEmprestimo(c1, List.of(l1, l2));
        realizarEmprestimoService.realizarEmprestimo(c1, List.of(l3));
        emprestimoService.relatorioEmprestimos();
        emprestimoService.devolverLivros(c1, List.of(l1, l3));
        emprestimoService.relatorioEmprestimos();
    }
}