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
                "Nome Inválido i");

        String regexNome = "[a-zA-Z]{2,}";
        String specialChar = "[^a-zA-Z ]";
        String regexNomeCompleto = "(" + regexNome + "\\s+)*" + regexNome;

        Pattern patternNomeCompleto = Pattern.compile(regexNomeCompleto);
        Pattern patternSpecialChar = Pattern.compile(specialChar);

        for (String nome : nomes) {
            boolean matchFound = false;
            boolean hasSpecialChar = patternSpecialChar.matcher(nome).find();
            
            if (!hasSpecialChar) {
                Matcher matcher = patternNomeCompleto.matcher(nome);
                matchFound = matcher.find();
            }
            
            System.out.print(nome);
            System.out.println(matchFound ? " OK" : " Incorreto");
        }
    }

}