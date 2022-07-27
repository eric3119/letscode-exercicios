package org.example.filters;
/**
 * Criar um arquivo com os MELHORES 20 filmes (rating) de terror (genre = 'Horror' - Usar regex).
 */

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.example.models.Filme;

public class FilmesGeneroHorrorFilter implements Predicate<Filme> {
    private static final Pattern p =  Pattern.compile("Horror", Pattern.CASE_INSENSITIVE);
    @Override
    public boolean test(Filme filme) {
        return p.matcher(filme.getGenre()).find();
    }
}
