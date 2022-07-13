package org.example.filters;

import java.util.Objects;
import java.util.function.Predicate;

import org.example.model.Cliente;
import org.example.model.Emprestimo;

public class EmprestimoPorCliente implements Predicate<Emprestimo> {

    private Cliente cliente;

    public EmprestimoPorCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean test(Emprestimo emprestimo) {
        return Objects.equals(emprestimo.getCliente(), cliente);
    }

}
