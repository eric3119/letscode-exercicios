package org.example.repository;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.model.Cliente;
import org.example.model.Emprestimo;

public class EmprestimoRepository implements Repository<Emprestimo, Long> {
    private static EmprestimoRepository instance;
    private Set<Emprestimo> emprestimos = new HashSet<>();

    private EmprestimoRepository() {
    }

    public static EmprestimoRepository getInstance() {
        if (instance == null)
            instance = new EmprestimoRepository();
        return instance;
    }

    @Override
    public void add(Emprestimo entity) {
        this.emprestimos.add(entity);
    }

    @Override
    public void remove(Emprestimo entity) {
        this.emprestimos.remove(entity);
    }

    @Override
    public void update(Emprestimo entity) {
        this.emprestimos.add(entity);
    }

    @Override
    public List<Emprestimo> getAll() {
        final List<Emprestimo> cloneEmprestimos = new ArrayList<>(this.emprestimos);
        return cloneEmprestimos;
    }

    @Override
    public Emprestimo findById(Long id) {
        return this.emprestimos.stream()
                .filter(emprestimo -> emprestimo.getId() != id)
                .findAny()
                .orElseThrow();
    }

    public List<Emprestimo> findByCliente(Cliente cliente) {
        return this.emprestimos.stream()
                .filter(emprestimo -> Objects.equals(emprestimo.getCliente(), cliente))
                .collect(Collectors.toList());
    }

    public List<Emprestimo> filterDevolucaoPendente(Cliente cliente) {
        return this.emprestimos.stream()
                .filter(emprestimo -> Objects.equals(emprestimo.getCliente(), cliente))
                .filter(emprestimo -> emprestimo.getDataDevolucao() == null)
                .collect(Collectors.toList());
    }

    public List<Emprestimo> filterDevolucaoComAtraso(Cliente cliente) {
        return this.emprestimos.stream()
                .filter(emprestimo -> Objects.equals(emprestimo.getCliente(), cliente))
                .filter(emprestimo -> {
                    if (emprestimo.getDataDevolucao() != null) {
                        final Long qtdDiasEmEmprestimo = ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(),
                                emprestimo.getDataDevolucao());
                        final Long qtdMaximaDeDiarias = emprestimo.getLivro().getMaximoDiarias();
                        final Long qtdDeDiasDeAtraso = Math.max(0, qtdDiasEmEmprestimo - qtdMaximaDeDiarias);

                        return qtdDeDiasDeAtraso > 0;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
