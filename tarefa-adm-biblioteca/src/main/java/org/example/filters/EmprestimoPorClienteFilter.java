package org.example.filters;

import java.util.Objects;
import java.util.function.Predicate;

import org.example.model.Cliente;
import org.example.model.Emprestimo;

public class EmprestimoPorClienteFilter implements Predicate<Emprestimo> {

    private Cliente cliente;

    public EmprestimoPorClienteFilter(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean test(Emprestimo emprestimo) {
        return Objects.equals(emprestimo.getCliente(), cliente);
    }

}
