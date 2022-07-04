package org.example.service;

import java.util.List;

import org.example.model.Cliente;
import org.example.model.Emprestimo;

public class ValidadorEmprestimosCliente implements ValidadorEmprestimos {

    @Override
    public void validar(List<Emprestimo> emprestimos) {

        for (Emprestimo emprestimo : emprestimos) {
            final Cliente cliente = emprestimo.getCliente();

            if (cliente.getNome() == null) {
                throw new RuntimeException("Nome do cliente não foi informado");
            }
            if (cliente.getEmail() == null) {
                throw new RuntimeException("Email do cliente não foi informado");
            }
            if (cliente.getTelefone() == null) {
                throw new RuntimeException("Telefone do cliente não foi informado");
            }
        }

    }
}
