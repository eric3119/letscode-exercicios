package org.example;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Crie um validador para nome completo: deve ter nome e sobrenome, cada um com
 * no mínimo duas letras.
 * Não aceite caracteres especiais.
 */

public class Main {

    public static void main(String[] args) {
        List<String> nomes = List.of(
                "Eric dos Santos Coelho",
                "Eric Coelho",
                "Nome Inválido",
                "Nome t");

        String regexNome = "[a-zA-Z]{2,}";

        String inicioNome = "(^" + regexNome + "\\s+)";
        String nomesIntermediarios = "(" + regexNome + "\\s+)*";
        String finalNome = regexNome + "$";

        String regexNomeCompleto = inicioNome + nomesIntermediarios + finalNome;

        Pattern patternNomeCompleto = Pattern.compile(regexNomeCompleto);

        for (String nome : nomes) {
            boolean matchFound = false;

            Matcher matcher = patternNomeCompleto.matcher(nome);
            matchFound = matcher.find();

            System.out.print(nome);
            System.out.println(matchFound ? " OK" : " Incorreto");
        }
    }

}