package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.example.strategy.AjusteSessao;
import org.example.strategy.ProximaSessao;

/**
 * Vai acontecer um evento internacional com transmissão online em São Paulo e
 * Paris.
 * 
 * Começa no dia 20 de Julho às 10h de São Paulo, mas deverá ter uma nova sessão
 * a cada 10 dias.
 * 
 * A cada sessão a hora de início deve avançar 2 horas, comparado com a sessão
 * anterior.
 * 
 * Cada sessão vai durar 6h.
 * 
 * O evento termina no fim de Outubro.
 * 
 * Crie a agenda do evento programaticamente utilizando o Java Time, deverá
 * fornecer:
 * 
 * A agenda das sessões para cada lugar.
 * Com o número da sessão.
 * Apresentar a data de cada sessão.
 * O horário de início e de fim, para cada lugar respectivamente.
 * Apresentar o dia da semana em português.
 * Organizar o código em classes e adotar algum padrão de projeto.
 */

public class Main {

    public static void main(String[] args) {
        List<Sessao> agenda = new ArrayList<>();
        List<AjusteSessao> strat = List.of(new ProximaSessao());

        Sessao sessao = getSessaoInicio();

        while (sessao.getDataHoraInicio().isBefore(Constants.DATA_FIM_EVENTO)) {
            agenda.add(sessao);
            for (AjusteSessao incrementarSessao : strat) {
                sessao = incrementarSessao.ajustar(sessao);
            }
        }

        agenda.forEach(System.out::println);
    }

    private static Sessao getSessaoInicio() {
        LocalDateTime inicio = LocalDateTime.of(2022, 7, 20, 10, 0);
        LocalDateTime fim = inicio.plusHours(Constants.TEMPO_SESSAO);
        Sessao sessao = new Sessao()
                .setDataHoraInicio(inicio)
                .setDataHoraFim(fim)
                .setNumeroSessao(1);
        return sessao;
    }

}