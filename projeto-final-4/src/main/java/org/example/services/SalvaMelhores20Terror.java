package org.example.services;

import org.example.comparators.SortByRatingFilmeComparator;
import org.example.filters.FilmesGeneroHorrorFilter;
import org.example.models.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SalvaMelhores20Terror implements Runnable {

    private final Set<Filme> filmes;

    public SalvaMelhores20Terror(Set<Filme> filmes){
        this.filmes = filmes;
    }

    @Override
    public void run() {
        this.salvar();
    }

    private void salvar(){
        List<Filme> filmes = this.filmes
                .stream()
                .sorted(new SortByRatingFilmeComparator())
                .filter(new FilmesGeneroHorrorFilter())
                .limit(20)
                .collect(Collectors.toList());

        try {
            Files.write(Path.of("melhores-20-terror.csv"), ParseFilmeToCSV.apply(filmes));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
