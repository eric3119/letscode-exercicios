package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Uma produção agrícola precisa gerar periodicamente relatórios.
 * 
 * Para já deram apenas como exemplo como pode ser gerado um dos seus relatórios
 * mensais.
 * 
 * Assim os outros relatórios podem ser gerados a partir da mesma implementação
 * deste.
 * 
 * A forma da construção dos relatórios precisa ser dinâmica, onde tem que
 * relacionar a informação em um arquivo de variáveis com um arquivo de modelo.
 */

public class Main {
    private static Path variaveisPath = Path.of("./desafio-tecnicas-6/src/main/java/org/example/variaveis.txt");
    private static Path modeloPath = Path.of("./desafio-tecnicas-6/src/main/java/org/example/modelo.txt");

    public static void main(String[] args) {

        initVariaveis();
        printModelo();

    }

    private static void initVariaveis() {

        try {
            Files.readAllLines(variaveisPath).stream().forEach(ModeloVariaveis::addVariavel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void printModelo() {
        try {
            Files.readAllLines(modeloPath).stream().map(linha -> {
                return new ModeloFormatter().setLinha(linha);
            }).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}