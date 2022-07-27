package org.example.filters;

import org.example.models.Filme;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FilmesPorAnoFilter implements Predicate<Filme> {
    private final int ano;
    public FilmesPorAnoFilter(int ano){
        this.ano = ano;
    }
    @Override
    public boolean test(Filme filme) {
        return Integer.parseInt(filme.getYear()) == ano;
    }
}
