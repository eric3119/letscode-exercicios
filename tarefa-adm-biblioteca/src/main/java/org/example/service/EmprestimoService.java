package org.example.service;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.model.Livro;
import org.example.repository.EmprestimoRepository;

public class EmprestimoService {

    private EmprestimoRepository emprestimoRepository;
    private static EmprestimoService instance;

    private EmprestimoService(EmprestimoRepository eRepository) {
        emprestimoRepository = eRepository;
    }

    public static EmprestimoService getInstance() {
        if (instance == null)
            instance = new EmprestimoService(EmprestimoRepository.getInstance());

        return instance;
    }

    public void devolverLivros(Cliente cliente, Collection<Livro> livros) {
        List<Emprestimo> emprestimosPendentes = this.emprestimoRepository.filterDevolucaoPendente(cliente);
        final CalcularMultaService calcularMultaService = new CalcularMultaService(List.of(new CalcularMultaAtraso()));

        System.out.printf("Valor de multas do cliente: R$ %s\n",
                NumberFormat.getCurrencyInstance().format(calcularMultaService.calcularMultas(cliente)));

        for (Emprestimo emprestimo : emprestimosPendentes) {
            if (livros.contains(emprestimo.getLivro())) {
                emprestimo.setDataDevolucao(LocalDateTime.now());
                this.emprestimoRepository.update(emprestimo);
            }
        }
        System.out.println("Livros devolvidos");
    }

    public void relatorioEmprestimos() {
        System.out.println(this.emprestimoRepository.getAll());
    }
}
