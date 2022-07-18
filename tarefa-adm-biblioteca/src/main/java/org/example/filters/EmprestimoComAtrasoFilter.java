package org.example.filters;

import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;

import org.example.model.Emprestimo;

public class EmprestimoComAtrasoFilter implements Predicate<Emprestimo> {

    @Override
    public boolean test(Emprestimo emprestimo) {
        if (emprestimo.getDataDevolucao() != null) {
            final Long qtdDiasEmEmprestimo = ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(),
                    emprestimo.getDataDevolucao());
            final Long qtdMaximaDeDiarias = emprestimo.getLivro().getMaximoDiarias();
            final Long qtdDeDiasDeAtraso = Math.max(0, qtdDiasEmEmprestimo - qtdMaximaDeDiarias);

            return qtdDeDiasDeAtraso > 0;
        }
        return false;
    }
    
}
