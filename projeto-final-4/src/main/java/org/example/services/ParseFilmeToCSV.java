package org.example.services;

import org.example.models.Filme;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ParseFilmeToCSV {

    public static List<String> apply(List<Filme> filmes) {
//        Rank,Title,Genre,Description,Director,Actors,Year,Runtime (Minutes),Rating,Votes,Revenue (Millions),Metascore
        return filmes.stream().map(
                filme -> new StringBuilder()
                        .append(filme.getRank())
                        .append(",")
                        .append(filme.getTitle())
                        .append(",")
                        .append(filme.getGenre())
                        .append(",")
                        .append(filme.getDescription())
                        .append(",")
                        .append(filme.getDirector())
                        .append(",")
                        .append(filme.getActors())
                        .append(",")
                        .append(filme.getYear())
                        .append(",")
                        .append(filme.getRuntime())
                        .append(",")
                        .append(filme.getRating())
                        .append(",")
                        .append(filme.getVotes())
                        .append(",")
                        .append(filme.getRevenue())
                        .append(",")
                        .append(filme.getMetascore())
                        .toString()
        ).collect(Collectors.toList());
    }
}
