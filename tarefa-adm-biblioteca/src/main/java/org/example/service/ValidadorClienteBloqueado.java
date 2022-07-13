package org.example.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.example.filters.EmprestimoComAtraso;
import org.example.filters.EmprestimoPorCliente;
import org.example.model.Cliente;
import org.example.model.Emprestimo;
import org.example.repository.EmprestimoRepository;

public class ValidadorClienteBloqueado implements ValidadorCliente {

    private final Integer QTD_DIAS_ATRASO_BLOQUEIO = 30;

    private EmprestimoRepository emprestimoRepository = EmprestimoRepository.getInstance();

    @Override
    public boolean validar(Cliente cliente) {
        final List<Emprestimo> emprestimos = this.emprestimoRepository
                .query(new EmprestimoPorCliente(cliente)
                        .and(new EmprestimoComAtraso()));

        for (Emprestimo emprestimo : emprestimos) {
            final Long dias = ChronoUnit.DAYS.between(emprestimo.getDataDevolucao(), LocalDateTime.now());
            if (dias <= QTD_DIAS_ATRASO_BLOQUEIO)
                throw new RuntimeException(
                        String.format("Cliente com bloqueio. Dias restantes para o desbloqueio: %d",
                                QTD_DIAS_ATRASO_BLOQUEIO - dias));
        }
        return false;
    }

}
