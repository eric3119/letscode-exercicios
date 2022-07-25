package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.example.filters.FilmesGeneroHorrorFilter;

public class Main {

    private static Path movies1Path = Path.of("./projeto-final-4/src/main/java/org/example/movies1.csv");
    private static Path movies2Path = Path.of("./projeto-final-4/src/main/java/org/example/movies2.csv");
    private static Path movies3Path = Path.of("./projeto-final-4/src/main/java/org/example/movies3.csv");

    public static void main(String[] args) {
        Stream<Filme> filmes;

        filmes = getFilmes(movies1Path);

        filmes.filter(new FilmesGeneroHorrorFilter().getQuery()).forEach(filme -> {
            //System.out.println(filme.getGenre())
        });
    }

    private static Stream<Filme> getFilmes(Path path) {
        Pattern pattern = Pattern.compile("(?<=^|,)(\"(?:[^\"]|\"\")*\"|[^,]*)");
        try {
            return Files.lines(path).skip(1)
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
                    })
                    .sorted((filme1, filme2) -> filme2.getRating().compareTo(filme1.getRating()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}