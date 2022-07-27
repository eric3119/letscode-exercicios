package org.example.services;

import org.example.models.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class CarregaFilmes implements Callable<Stream<Filme>> {

    private final Path path;
    private final int skip;

    public CarregaFilmes(Path path){
        this.path = path;
        this.skip = 0;
    }

    public CarregaFilmes(Path path, int skip){
        this.path = path;
        this.skip = skip;
    }

    @Override
    public Stream<Filme> call() throws Exception {
        return getFilmes();
    }
    private Stream<Filme> getFilmes() {
        Pattern pattern = Pattern.compile("(?<=^|,)(\"(?:[^\"]|\"\")*\"|[^,]*)");
        try {
            return Files.lines(this.path).skip(this.skip)
                    .map(linha -> {
                        List<String> cols = new ArrayList<>();
                        Matcher matcher = pattern.matcher(linha);
                        while (matcher.find()) {
                            cols.add(matcher.group(1));
                        }
                        if(cols.size() != 12){
                            System.out.print(linha);
                        }
                        return Filme.of(cols);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
