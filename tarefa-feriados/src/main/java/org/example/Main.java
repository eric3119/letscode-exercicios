package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
        private static Locale ptBR = new Locale("pt", "BR");

        public static void main(String[] args) {

                String diaMesCSV = "07/09, 12/10, 02/11, 15/11, 25/12, 01/01";
                String[] diaMesStrings = diaMesCSV.split(",");

                Integer curretYear = LocalDate.now().getYear();

                for (int year = curretYear - 1; year <= curretYear + 1; year++) {
                        for (String diaMes : diaMesStrings) {
                                print(MonthDay.parse(diaMes.trim(), DateTimeFormatter.ofPattern("dd/MM")), year);
                        }
                        System.out.println();
                }
        }

        private static void print(MonthDay monthDay, Integer year) {

                Integer month = monthDay.getMonthValue();
                Integer dayOfMonth = monthDay.getDayOfMonth();

                DayOfWeek dayOfWeek = LocalDate.of(year, month, dayOfMonth).getDayOfWeek();
                String dayOfWeekDisplayName = dayOfWeek.getDisplayName(TextStyle.FULL, ptBR);

                StringBuilder sBuilder = new StringBuilder()
                                .append("#Ano ")
                                .append(year)
                                .append(": #")
                                .append(padStart(dayOfMonth, 2, '0'))
                                .append("/")
                                .append(padStart(month, 2, '0'))
                                .append(" - ")
                                .append(dayOfWeekDisplayName);

                if (dayOfWeek == DayOfWeek.TUESDAY || dayOfWeek == DayOfWeek.THURSDAY)
                        sBuilder.append(" * feriado prolongado");

                sBuilder.append(" ");

                System.out.print(sBuilder);
        }

        // private static String padStart(String input, Integer maxLength, Character replaceCharacter) {
        //         return String.format("%1$" + maxLength + "s", input).replace(' ', replaceCharacter);
        // }

        private static String padStart(Integer input, Integer maxLength, Character replaceCharacter) {
                return String.format("%1$" + maxLength + "s", input).replace(' ', replaceCharacter);
        }
}