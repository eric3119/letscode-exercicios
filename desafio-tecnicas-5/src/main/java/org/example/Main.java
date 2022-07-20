package org.example;

import java.util.List;
import java.util.Map;

/**
 * Baseado na lista de contatos abaixo, obtenha os nomes de quem possuí o número
 * 7 no seu número de telefone e liste os respectivos nomes em ordem alfabética.
 */

public class Main {
    public static void main(String[] args) {
        List<Map<String, String>> contatos = List.of(
                Map.of("nome", "João", "telefone", "9329823423"),
                Map.of("nome", "Maria", "telefone", "9124235435"),
                Map.of("nome", "Marta", "telefone", "9456335387"),
                Map.of("nome", "José", "telefone", "9632874738"),
                Map.of("nome", "Judas", "telefone", "9329244683"));

        contatos.stream()
                .filter(contato -> contato.get("telefone")
                        .contains("7"))
                .sorted((Map<String, String> o1, Map<String, String> o2) -> {
                    return o1.get("nome").compareTo(o2.get("nome"));
                }).forEach(System.out::println);

    }

}