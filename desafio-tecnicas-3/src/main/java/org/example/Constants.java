package org.example;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Locale;

public class Constants {
    public static final Integer TEMPO_SESSAO = 6;
    public static final Integer INCREMENTO_HORAS_PROXIMA_SESSAO = 2;
    public static final Integer INCREMENTO_DIAS_PROXIMA_SESSAO = 10;
    public static final LocalDateTime DATA_FIM_EVENTO = LocalDateTime.of(2022, Month.OCTOBER, 31, 23, 59);
    public static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    public static final Locale LOCALE = new Locale("pt", "BR");
}
