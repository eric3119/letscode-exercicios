package org.example.filters;

import java.util.function.Predicate;

import org.example.model.Emprestimo;

public class EmprestimoPendenteFilter implements Predicate<Emprestimo> {

    @Override
    public boolean test(Emprestimo emprestimo) {
        return emprestimo.getDataDevolucao() == null;
    }

}
