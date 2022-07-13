package org.example.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.example.implementations.Cliente;

public abstract class CalculaIdade {

    public static Long calcular(Cliente cliente) {
        return ChronoUnit.YEARS.between(cliente.getDataNascimento(), LocalDate.now());
    }
}
