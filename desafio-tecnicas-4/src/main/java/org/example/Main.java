package org.example;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Há um jardim cheio de lírios.
 * 
 * Tem 100 vermelhos, 50 amarelos e 25 azuis, todos bem misturadas, produzindo
 * um efeito bem colorido.
 * 
 * Assuma que o lírio vermelho é o número 1, o amarelo o número 2 e o azul será
 * o número 3.
 * 
 * Inicialize um stream com as sequências onde cada número representa uma flor e
 * misture tudo.
 * 
 * Faça a colheita de todas as flores azuis e de 25% das outras flores.
 * 
 * Apresente o total de flores que sobram no jardim.
 * 
 * Utilize apenas stream, é proibido utilizar arrays e collections.
 */

public class Main {

    public static void main(String[] args) {

        Stream<Integer> jardim = Stream.concat(Stream.concat(
                IntStream.range(0, 100).map(o -> 1).boxed(),
                IntStream.range(0, 50).map(o -> 2).boxed()),
                IntStream.range(0, 25).map(o -> 3).boxed());

        jardim
                .sorted(shuffle)
                .filter(o -> (o != 3))
                .skip((25 / 100) * (150))
                .forEach(System.out::println);
    }

    private static Comparator<Integer> shuffle = (Integer a, Integer b) -> {
        Double rand = Math.random();
        if (rand < 0.5)
            return -1;
        if (rand == 0.5)
            return 0;
        else
            return 1;
    };
}