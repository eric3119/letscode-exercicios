package org.example;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Main {
        private static DateTimeFormatter ptBRDateFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        public static void main(String[] args) {
                BigDecimal valorTotal = BigDecimal.valueOf(123);
                LocalDate dataAtual = LocalDate.now();
                Integer qtdParcelas = 12;

                for (int i = 0; i < qtdParcelas; i++) {
                        LocalDate vencimento = dataAtual.plusMonths(i);

                        if (vencimento.getDayOfWeek() == DayOfWeek.SATURDAY
                                        || vencimento.getDayOfWeek() == DayOfWeek.SUNDAY)
                                vencimento = vencimento.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

                        StringBuilder stringBuilder = new StringBuilder()
                                        .append("Parcela: ")
                                        .append(padStart(i + 1, 2, '0'))
                                        .append("/")
                                        .append(qtdParcelas)
                                        .append(" - ")
                                        .append("Vencimento: ")
                                        .append(vencimento.format(ptBRDateFormatter))
                                        .append(" - ")
                                        .append("Valor: ")
                                        .append(valorTotal.divide((BigDecimal.valueOf(qtdParcelas))));
                        System.out.println(stringBuilder);
                        // Numero da parcela - Data de vencimento - Valor parcela
                }
        }

        private static String padStart(Integer input, Integer maxLength, Character replaceCharacter) {
                return String.format("%1$" + maxLength + "s", input).replace(' ', replaceCharacter);
        }
}