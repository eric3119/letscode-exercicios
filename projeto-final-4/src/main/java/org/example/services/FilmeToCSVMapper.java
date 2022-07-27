package org.example.services;

import org.example.models.Filme;

public final class FilmeToCSVMapper {

    public static String apply(Filme filme) {
//        Rank,Title,Genre,Description,Director,Actors,Year,Runtime (Minutes),Rating,Votes,Revenue (Millions),Metascore
        return new StringBuilder()
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
                        .toString();
    }
}
