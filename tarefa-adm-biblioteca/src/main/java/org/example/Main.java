package org.example;

import org.example.model.Cliente;
import org.example.model.Livro;
import org.example.service.EmprestimoService;

import java.util.List;

public class Main {

    private static EmprestimoService emprestimoService = EmprestimoService.getInstance();

    public static void main(String[] args) {
        Cliente c1 = new Cliente()
                .setEmail("teste@teste.com")
                .setNome("Teste")
                .setTelefone("999999999");
        Livro l1 = new Livro()
                .setTitulo("Titulo");

        emprestimoService.realizarEmprestimo(c1, List.of(l1));
    }
}