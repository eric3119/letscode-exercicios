package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.models.Filme;
import org.example.services.CarregaFilmes;
import org.example.services.SalvaMelhores20Terror;
import org.example.services.SalvaMelhores50PorAno;

public class Main {

    private static final Path movies1Path = Path.of("./src/main/java/org/example/movies1.csv");
    private static final Path movies2Path = Path.of("./src/main/java/org/example/movies2.csv");
    private static final Path movies3Path = Path.of("./src/main/java/org/example/movies3.csv");

    private static final DateTimeFormatter ptbr = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    public static void main(String[] args) {
        LocalDateTime inicio = LocalDateTime.now();

        ExecutorService executorServiceCarregar = Executors.newCachedThreadPool();

        Set<Filme> filmes = Stream.of(
            executorServiceCarregar.submit(new CarregaFilmes(movies1Path, 1)),
            executorServiceCarregar.submit(new CarregaFilmes(movies2Path)),
            executorServiceCarregar.submit(new CarregaFilmes(movies3Path))
        ).flatMap(
                filmesStream -> {
                    try {
                        return filmesStream.get();
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).collect(Collectors.toSet());

        executorServiceCarregar.shutdown();

        ExecutorService executorServiceSalvar = Executors.newCachedThreadPool();

        executorServiceSalvar.execute(new SalvaMelhores20Terror(filmes));
        Set<String> anos = filmes.stream()
            .reduce(
                new HashSet<>(),
                (a,b) -> {
                    a.add(b.getYear());
                    return a;
                },
                (a,b) -> {
                    a.addAll(b);
                    return a;
                }
            );

        anos.forEach(ano -> executorServiceSalvar.execute(new SalvaMelhores50PorAno(filmes, Integer.parseInt(ano))));

        executorServiceSalvar.shutdown();

        try {
            if(executorServiceSalvar.awaitTermination(1000, TimeUnit.MILLISECONDS)){
                LocalDateTime fim = LocalDateTime.now();
                Files.write(Path.of("relatorio.txt"), Collections.singleton(new StringBuilder()
                        .append("Incio processamento: ")
                        .append(ptbr.format(inicio))
                        .append("\n")
                        .append("Fim processamento: ")
                        .append(ptbr.format(fim))
                        .append("\n")
                        .append("Tempo em milisegundos: ")
                        .append(ChronoUnit.MILLIS.between(inicio, fim))
                        .append(" milisegundos\n")
                        .append("Tempo em segundos: ")
                        .append(ChronoUnit.SECONDS.between(inicio, fim))
                        .append(" segundos")
                        .toString()));
            }
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}