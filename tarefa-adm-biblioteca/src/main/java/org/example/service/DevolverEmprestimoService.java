package org.example.service;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.example.filters.EmprestimoPendente;
import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;

public class DevolverEmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private static DevolverEmprestimoService instance;

    private DevolverEmprestimoService(EmprestimoRepository eRepository) {
        emprestimoRepository = eRepository;
    }

    public static DevolverEmprestimoService getInstance() {
        if (instance == null)
            instance = new DevolverEmprestimoService(EmprestimoRepository.getInstance());

        return instance;
    }

    public void devolverLivros(Cliente cliente, Collection<Livro> livros) {
        List<Emprestimo> emprestimosPendentes = this.emprestimoRepository
                .queryFilteredByCliente(cliente, new EmprestimoPendente());
        final CalcularMultaService calcularMultaService = new CalcularMultaService(List.of(new CalcularMultaAtraso()));

        System.out.printf("Valor de multas do cliente: %s\n",
                NumberFormat.getCurrencyInstance().format(calcularMultaService.calcularMultas(cliente)));

        for (Emprestimo emprestimo : emprestimosPendentes) {
            if (livros.contains(emprestimo.getLivro())) {
                emprestimo.setDataDevolucao(LocalDateTime.now());
                this.emprestimoRepository.update(emprestimo);
            }
        }
        System.out.println("Livros devolvidos: ");
        for (Livro livro : livros) {
            System.out.printf("\t");
            System.out.println(livro);
        }
    }

    public void relatorioEmprestimosPendentes() {
        System.out.println("Listagem de emprestimos pendentes");
        System.out.println(this.emprestimoRepository.getAll().stream()
                .filter(emprestimo -> emprestimo.getDataDevolucao() == null)
                .collect(Collectors.toList()));
    }
}
