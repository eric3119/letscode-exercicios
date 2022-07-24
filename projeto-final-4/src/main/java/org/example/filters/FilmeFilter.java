package org.example.filters;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.example.Filme;

public interface FilmeFilter {
    Predicate<Filme> getQuery();

    default List<Filme> filter(List<Filme> filmes) {
        return filmes.stream().filter(getQuery()).collect(Collectors.toList());
    }
}
