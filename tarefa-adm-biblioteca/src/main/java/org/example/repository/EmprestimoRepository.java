package org.example.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        final List<Emprestimo> cloneEmprestimos = List.copyOf(this.emprestimos);
        return cloneEmprestimos;
    }

    @Override
    public Emprestimo findById(Long id) {
        return this.emprestimos.stream()
                .filter(emprestimo -> emprestimo.getId() != id)
                .findAny()
                .orElseThrow();
    }

    @Override
    public List<Emprestimo> query(Predicate<Emprestimo> specification) {
        return this.emprestimos.stream().filter(specification).collect(Collectors.toList());
    }
}
