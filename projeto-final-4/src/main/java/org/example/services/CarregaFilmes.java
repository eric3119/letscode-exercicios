package org.example.services;

import org.example.models.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class CarregaFilmes implements Callable<Stream<Filme>> {

    private final Path path;

    public CarregaFilmes(Path path){
        this.path = path;
    }
    @Override
    public Stream<Filme> call() {
        return loadFilmes();
    }
    private Stream<Filme> loadFilmes() {
        try {
            return Files.lines(this.path)
                    .map(CSVToFilmeMapper::apply);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
