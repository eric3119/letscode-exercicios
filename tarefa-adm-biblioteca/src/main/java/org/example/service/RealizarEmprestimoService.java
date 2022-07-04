package org.example.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;

public class RealizarEmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private static RealizarEmprestimoService instance;

    private List<ValidadorEmprestimos> validacoesEmprestimos;
    private List<ValidadorCliente> validacoesCliente;

    private RealizarEmprestimoService(EmprestimoRepository eRepository, List<ValidadorEmprestimos> vEmprestimo, List<ValidadorCliente> vCliente) {
        emprestimoRepository = eRepository;
        validacoesEmprestimos = vEmprestimo;
        validacoesCliente = vCliente;
    }

    public static RealizarEmprestimoService getInstance(List<ValidadorEmprestimos> vEmprestimo, List<ValidadorCliente> vCliente) {
        if (instance == null)
            instance = new RealizarEmprestimoService(EmprestimoRepository.getInstance(), vEmprestimo, vCliente);

        return instance;
    }

    public void realizarEmprestimo(Cliente cliente, Collection<Livro> livros) {

        final List<Emprestimo> emprestimos = new ArrayList<>();
        livros.forEach(livro -> {
            final Emprestimo novoEmprestimo = new Emprestimo()
                    .setCliente(cliente)
                    .setLivro(livro)
                    .setDataEmprestimo(LocalDateTime.now());
            emprestimos.add(novoEmprestimo);
        });

        for (ValidadorCliente validor : validacoesCliente) {
            validor.validar(cliente);
        }

        for (ValidadorEmprestimos validor : validacoesEmprestimos) {
            validor.validar(emprestimos);
        }

        for (Emprestimo emprestimo : emprestimos) {
            this.emprestimoRepository.add(emprestimo);
        }

        System.out.println("Emprestimo realizado");
        System.out.println("Livros: ");
        for (Livro livro : livros) {
            System.out.printf("\t");
            System.out.println(livro);
        }
    }
}
