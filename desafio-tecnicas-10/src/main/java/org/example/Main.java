package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * Um sistema precisa realizar a exportação de dados a partir de consultas em
 * diversos sistemas.
 * 
 * Simule a criação de 4 consultas a sistemas diversos e a criação de um arquivo
 * contendo os dados de todas as consultas.
 * 
 * As 4 consultas devem ser realizadas paralelamente e após a finalização das
 * consultas um arquivo único deve ser gerado com os dados.
 * 
 * Utilizar a classe ExecutorService para realizar a sincronização do
 * processamento.
 */

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<Future<String>> consultas = new ArrayList<>();

         consultas.add(executorService.submit(() -> {
             Thread.sleep(2000);
             return "Consulta 1";
         }));

        consultas.add(executorService.submit(() -> {
            Thread.sleep(3000);
            return "Consulta 2";
        }));

        consultas.add(executorService.submit(() -> {
            Thread.sleep(1000);
            return "Consulta 3";
        }));

        consultas.add(executorService.submit(() -> {
            Thread.sleep(5000);
            return "Consulta 4";
        }));

        executorService.shutdown();

        String linhas = consultas.stream()
                    .map(stringFuture -> {
                        try {
                            return stringFuture.get();
                        } catch (InterruptedException | ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.joining("\n"));

        try {
            Files.write(Path.of("resultado.txt"), Collections.singleton(linhas));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Fim processo main");
    }
}