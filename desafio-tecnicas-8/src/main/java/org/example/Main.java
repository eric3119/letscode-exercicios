package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A partir de um arquivo TXT posicional com o seguinte conteudo:
 * 
 * https://s3-sa-east-1.amazonaws.com/lcpi/67fdd982-9281-4bb3-bf89-f7c4b157b8f8.txt
 * 
 * Faça a leitura do arquivo (utilizando a api NIO 2) e faça a transformaçao
 * para uma lista de objetos Pessoa (utilizando stream):
 */

public class Main {
    private static Path entradaPath = Path.of("./desafio-tecnicas-8/src/main/java/org/example/entrada.txt");

    public static void main(String[] args) {
        List<Pessoa> pessoas;

        try {
            pessoas = Files.lines(entradaPath).skip(1).map(linha -> {
                return new Pessoa()
                    .setNome(getNomePosicional(linha))
                    .setCidade(getCidadePosicional(linha))
                    .setUf(getUFPosicional(linha))
                    .setDataNascimento(getDataNascimentoPosicional(linha));
            }).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        pessoas.forEach(System.out::println);
    }

    private static String getNomePosicional(String linha) {
        return linha.substring(Posicional.INICIO_NOME, Posicional.FIM_NOME).trim();
    }

    private static String getCidadePosicional(String linha) {
        return linha.substring(Posicional.INICIO_CIDADE, Posicional.FIM_CIDADE).trim();
    }

    private static String getUFPosicional(String linha) {
        return linha.substring(Posicional.INICIO_UF, Posicional.FIM_UF).trim();
    }

    private static LocalDate getDataNascimentoPosicional(String linha) {
        String dataString = linha.substring(Posicional.INICIO_DATA_NASC, Posicional.FIM_DATA_NASC).trim();
        return LocalDate.parse(dataString);
    }
}