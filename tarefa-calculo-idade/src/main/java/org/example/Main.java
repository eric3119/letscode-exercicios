package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
        private static Locale ptBR = new Locale("pt", "BR");

        private static DateTimeFormatter ptBRDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - EEEE");

        public static void main(String[] args) {
                String pessoasCSV = "Roberto:21-07-08,Ricardo:20-07-08,José:23-07-11";
                String[] pessoasStrings = pessoasCSV.split(",");

                for (String pessoaString : pessoasStrings) {
                        String nome = pessoaString.split(":")[0];
                        String dataNascimentoString = pessoaString.split(":")[1];

                        final int anoAtual = Year.now().getValue();

                        final DateTimeFormatter dataNascimentoFormatterInput = new DateTimeFormatterBuilder()
                                        .appendValueReduced(ChronoField.YEAR, 2, 2, anoAtual - 99)
                                        .appendPattern("-MM-dd")
                                        .toFormatter(ptBR);

                        LocalDate dataNascimento = LocalDate.parse(dataNascimentoString,
                                        dataNascimentoFormatterInput);

                        DayOfWeek dayOfWeek = dataNascimento.getDayOfWeek();
                        String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.FULL, ptBR);

                        Long idade = getIdadeHoje(dataNascimento);

                        StringBuilder sBuilder = new StringBuilder()
                                        .append(nome)
                                        .append(" - ")
                                        .append(dataNascimento.format(ptBRDateFormatter))
                                        .append(" - ")
                                        .append(capitalize(dayOfWeekDisplayName))
                                        .append(" - ")
                                        .append(idade)
                                        .append(" ")
                                        .append(idade > 1 ? "anos" : "ano");

                        System.out.println(sBuilder);
                }
        }

        private static Long getIdadeHoje(LocalDate dataNascimento) {
                return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        }

        private static String capitalize(String input) {
                String begin = input.substring(0, 1).toUpperCase();
                String inputCapitalized = begin + input.substring(1);

                return inputCapitalized;
        }
}