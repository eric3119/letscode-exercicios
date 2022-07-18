package org.example;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

/**
 * A partir de uma lista de pessoas (nome e data nascimento no formato
 * dd-MM-yy), calcular a idade de cada pessoa em referência a data de hoje.
 * A idade maxima das pessoas é de 99 anos.
 */

public class Main {
    private static Locale ptBR = new Locale("pt", "BR");

    private static DateTimeFormatter ptBRDateFormatterOut = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static DateTimeFormatter ptBRDateFormatterIn = new DateTimeFormatterBuilder()
            .appendPattern("dd-MM-")
            .appendValueReduced(ChronoField.YEAR, 2, 2, Year.now().getValue() - 99)
            .toFormatter(ptBR);

    public static void main(String[] args) {
        List<Pessoa> pessoas = List.of(
                new Pessoa()
                        .setNome("Pessoa 1")
                        .setDataNascimento("22-10-07"),
                new Pessoa()
                        .setNome("Pessoa 2")
                        .setDataNascimento("17-06-96"),
                new Pessoa()
                        .setNome("Pessoa 3")
                        .setDataNascimento("01-01-23"));

        for (Pessoa pessoa : pessoas) {
            LocalDate dataNascimento = getDateFromString(pessoa.getDataNascimento());

            StringBuilder sb = new StringBuilder()
                    .append(pessoa.getNome())
                    .append(" - Data de Nascimento: ")
                    .append(ptBRDateFormatterOut.format(dataNascimento))
                    .append(" - Idade: ")
                    .append(getIdadeHoje(dataNascimento))
                    .append(" ano(s)");
            System.out.println(sb);
        }
    }

    private static LocalDate getDateFromString(String date) {
        return LocalDate.parse(date, ptBRDateFormatterIn);
    }

    private static Long getIdadeHoje(LocalDate dataNascimento) {
        return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }
}