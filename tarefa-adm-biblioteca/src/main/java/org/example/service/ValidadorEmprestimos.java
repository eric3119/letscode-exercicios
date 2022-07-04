package org.example.service;

import java.util.List;

import org.example.model.Emprestimo;

public interface ValidadorEmprestimos {
    void validar(List<Emprestimo> emprestimos);
}
