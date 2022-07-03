package org.example.service;

import org.example.model.Cliente;
import org.example.model.Emprestimo;

public class ValidadorEmprestimoCliente implements ValidadorEmprestimo {

    @Override
    public void validar(Emprestimo emprestimo) {

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
