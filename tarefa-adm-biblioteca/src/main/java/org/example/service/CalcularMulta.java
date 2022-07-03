package org.example.service;

import java.math.BigDecimal;

import org.example.model.Emprestimo;

public interface CalcularMulta {
    BigDecimal calcular(Emprestimo emprestimo);
}
