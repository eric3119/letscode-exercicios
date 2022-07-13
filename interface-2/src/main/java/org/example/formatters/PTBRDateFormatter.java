package org.example.formatters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PTBRDateFormatter {

    private static DateTimeFormatter ptBRDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String format(LocalDate date) {
        return ptBRDateFormatter.format(date);
    }

    public static DateTimeFormatter getFormatter() {
        return ptBRDateFormatter;
    }
}
