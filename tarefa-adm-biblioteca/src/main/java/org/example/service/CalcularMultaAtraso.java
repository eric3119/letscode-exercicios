package org.example.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.example.model.Emprestimo;

public class CalcularMultaAtraso implements CalcularMulta {

    private final BigDecimal MULTA_DIARIA = new BigDecimal(0.05);
    private final BigDecimal MULTA_DIARIA_MAXIMO = new BigDecimal(0.20);

    @Override
    public BigDecimal calcular(Emprestimo emprestimo) {
        final Long qtdDiasEmEmprestimo = ChronoUnit.DAYS.between(emprestimo.getDataEmprestimo(), LocalDateTime.now());
        final Long qtdMaximaDeDiarias = emprestimo.getLivro().getMaximoDiarias();
        final Long qtdDeDiasDeAtraso = Math.max(0, qtdDiasEmEmprestimo - qtdMaximaDeDiarias);

        final BigDecimal custoDiaria = BigDecimal.valueOf(emprestimo.getLivro().getCustoDiario());
        final BigDecimal custoMultaDiaria = this.MULTA_DIARIA.multiply(custoDiaria);

        final BigDecimal valorMultaMaxima = this.MULTA_DIARIA_MAXIMO
                .multiply(custoDiaria.multiply(BigDecimal.valueOf(qtdMaximaDeDiarias)));
        final BigDecimal valorMultaPorAtraso = BigDecimal.valueOf(qtdDeDiasDeAtraso).multiply(custoMultaDiaria);

        return valorMultaPorAtraso.min(valorMultaMaxima);
    }

}
