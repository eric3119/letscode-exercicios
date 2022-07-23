package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

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
        List<LinhaModeloFormatter> linhaModeloFormatterList = getLinhaModeloFormatter();
        String textoFormatado = getTextoFormatado(linhaModeloFormatterList);

        Path destRelatorio = Paths
                .get("./desafio-tecnicas-6/src/main/java/org/example/relatorio-" + ModeloVariaveis.get("mes") + ".txt");
        salvaRelatorio(destRelatorio, textoFormatado);

        printRelatorio(textoFormatado);
    }

    private static void initVariaveis() {

        try {
            Files.readAllLines(variaveisPath).stream().forEach(ModeloVariaveis::addVariavel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static List<LinhaModeloFormatter> getLinhaModeloFormatter() {
        try {
            return Files.readAllLines(modeloPath).stream().map(linha -> {
                return new LinhaModeloFormatter().setLinha(linha);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getTextoFormatado(List<LinhaModeloFormatter> linhaModeloFormatterList) {
        return linhaModeloFormatterList.stream()
                .reduce(
                        new StringBuilder(),
                        (partial, modeloFormatter) -> partial
                                .append(modeloFormatter.getLinhaFormatada() + System.lineSeparator()),
                        (acc1, acc2) -> acc1.append(acc2))
                .toString();
    }

    private static void printRelatorio(String textoFormatado) {
        System.out.println(textoFormatado);
    }

    private static void salvaRelatorio(Path path, String textoFormatado) {
        try {
            Files.write(path, textoFormatado.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}