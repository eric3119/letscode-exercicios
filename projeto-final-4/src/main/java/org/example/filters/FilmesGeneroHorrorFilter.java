package org.example.filters;
/**
 * Criar um arquivo com os MELHORES 20 filmes (rating) de terror (genre = 'Horror' - Usar regex).
 */

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.example.Filme;

public class FilmesGeneroHorrorFilter implements FilmeFilter {
    private static Pattern p =  Pattern.compile("Horror", Pattern.CASE_INSENSITIVE);

    @Override
    public Predicate<Filme> getQuery() {
        return (filme) -> p.matcher(filme.getGenre()).find();
    }
}
