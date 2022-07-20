package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public abstract class DateUtils {
    public static int getQtdDiasUteisMes(Month mes, int ano) {
        int dias = 0;
        int lastDay = getLastDay(mes.getValue(), ano);
        for (int i = 1; i <= lastDay; i++) {
            DayOfWeek diaDaSemana = LocalDate.of(ano, mes, i).getDayOfWeek();
            if (diaDaSemana != DayOfWeek.SUNDAY &&
                    diaDaSemana != DayOfWeek.SATURDAY) {
                dias++;
            }
        }

        return dias;
    }

    public static int getLastDay(int mes, int ano) {
        LocalDate date = LocalDate.of(ano, mes, 1);
        return date.getMonth().length(date.isLeapYear());
    }
}
