package org.example.services;

import org.example.comparators.SortByRatingFilmeComparator;
import org.example.filters.FilmesPorAnoFilter;
import org.example.models.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SalvaMelhores50PorAno implements Runnable {

    private final Set<Filme> filmes;
    private final int ano;

    public SalvaMelhores50PorAno(Set<Filme> filmes, int ano){
        this.filmes = filmes;
        this.ano = ano;
    }

    @Override
    public void run() {
        this.salvar();
    }

    private void salvar(){
        List<Filme> filmes = this.filmes
                .stream()
                .sorted(new SortByRatingFilmeComparator())
                .filter(new FilmesPorAnoFilter(ano))
                .limit(50)
                .collect(Collectors.toList());

        try {
            String filmesCSV = filmes.stream().map(FilmeToCSVMapper::apply).collect(Collectors.joining(System.lineSeparator()));
            Files.write(Path.of("melhores-50-ano-" + this.ano + ".csv"),  Collections.singleton(filmesCSV));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
