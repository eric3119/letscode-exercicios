package org.example;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.example.implementations.Cliente;
import org.example.implementations.Cliente.Sexo;
import org.example.interfaces.Verificador;
import org.example.interfaces.VerificadorCliente;

public class Main {

    public static void main(String[] args) {
        List<Cliente> clientes = List.of(
                new Cliente()
                        .setNome("Cliente 1")
                        .setDataNascimento(LocalDate.of(2007, 7, 7))
                        .setSexo(Sexo.MASCULINO),
                new Cliente()
                        .setNome("Cliente 2")
                        .setDataNascimento(LocalDate.of(2004, 7, 7))
                        .setSexo(Sexo.MASCULINO));

        System.out.println(filtrar(clientes, new VerificadorCliente()));
    }

    static List<Cliente> filtrar(List<Cliente> clientes, Verificador<Cliente> verificador) {
        return clientes.stream().filter(verificador::verificar).collect(Collectors.toList());
    }
}