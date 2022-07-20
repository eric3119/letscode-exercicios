package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String filename = "C:\\Users\\F2964864\\Downloads\\projeto-final-tecnicas\\movies1.csv";

        // initialize Path object
        Path path = Paths.get(filename);

        Pattern pattern = Pattern.compile("(\"[^\"]*\"|[^,]*),?");

        try {
            List<Filme> filmes = Files.lines(path).skip(1)
                    .map(linha -> {
                        List<String> cols = new ArrayList<>();
                        Matcher matcher = pattern.matcher(linha);
                        System.out.println(matcher.group());
                        for (int i = 1; i <= matcher.groupCount(); ++i) {
                            try {
                                cols.add(matcher.group(i));

                            } catch (Exception e) {
                                
                                System.out.println(linha);
                            }
                        }
                        return Filme.of(cols);
                    })
                    .collect(Collectors.toList());
            System.out.println(filmes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}