package org.example.services;

import org.example.models.Filme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CSVToFilmeMapper {

    private static final Pattern pattern = Pattern.compile("(?<=^|,)(\"(?:[^\"]|\"\")*\"|[^,]*)");

    public static Filme apply(String linha) {
        List<String> cols = new ArrayList<>();
        Matcher matcher = pattern.matcher(linha);
        while (matcher.find()) {
            cols.add(matcher.group(1));
        }
        return Filme.of(cols);
    }
}
