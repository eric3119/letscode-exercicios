package org.example.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;

public class RealizarEmprestimoService {

    private final Integer QTD_DIAS_ATRASO_BLOQUEIO = 30;

    private EmprestimoRepository emprestimoRepository;
    private static RealizarEmprestimoService instance;

    private List<ValidadorEmprestimo> validacoes;

    private RealizarEmprestimoService(EmprestimoRepository eRepository, List<ValidadorEmprestimo> vEmprestimo) {
        emprestimoRepository = eRepository;
        validacoes = vEmprestimo;
    }

    public static RealizarEmprestimoService getInstance(List<ValidadorEmprestimo> vEmprestimo) {
        if (instance == null)
            instance = new RealizarEmprestimoService(EmprestimoRepository.getInstance(), vEmprestimo);

        return instance;
    }

    public void realizarEmprestimo(Cliente cliente, Collection<Livro> livros) {

        this.validarUsuarioComEmprestimosPendentes(cliente, livros);
        this.validarUsuarioComBloqueio(cliente);

        livros.forEach(livro -> {
            final Emprestimo novoEmprestimo = new Emprestimo()
                    .setCliente(cliente)
                    .setLivro(livro)
                    .setDataEmprestimo(LocalDateTime.now());

            for (ValidadorEmprestimo validor : validacoes) {
                validor.validar(novoEmprestimo);
            }

            this.emprestimoRepository.add(novoEmprestimo);
        });

        System.out.println("Emprestimo realizado");
    }

    private void validarUsuarioComBloqueio(Cliente cliente) {
        final List<Emprestimo> emprestimos = this.emprestimoRepository.filterDevolucaoComAtraso(cliente);
        for (Emprestimo emprestimo : emprestimos) {
            final Long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), LocalDateTime.now());
            if (dias <= QTD_DIAS_ATRASO_BLOQUEIO)
                throw new RuntimeException(
                        String.format("Cliente com bloqueio. Dias restantes para o desbloqueio: %d", QTD_DIAS_ATRASO_BLOQUEIO - dias));
        }
    }

    private void validarUsuarioComEmprestimosPendentes(Cliente cliente, Collection<Livro> livros) {
        final List<Emprestimo> emprestimosPendentes = this.emprestimoRepository.filterDevolucaoPendente(cliente);

        if (emprestimosPendentes.size() + livros.size() > 2)
            throw new RuntimeException(
                    String.format("Quantidade máxima de livros emprestados atingida: Excedeu %d livro(s)",
                            (emprestimosPendentes.size() + livros.size()) - 2));
    }
}
