package org.example.strategy;

import java.time.LocalDateTime;

import org.example.Constants;
import org.example.Sessao;

public class ProximaSessao implements AjusteSessao {

    @Override
    public Sessao ajustar(Sessao sessao) {
        LocalDateTime inicioProximaSessao = sessao.getDataHoraInicio().plusDays(Constants.INCREMENTO_DIAS_PROXIMA_SESSAO)
                .plusHours(Constants.INCREMENTO_HORAS_PROXIMA_SESSAO);
                
        LocalDateTime fimProximaSessao = inicioProximaSessao.plusHours(Constants.TEMPO_SESSAO);

        Sessao proximaSessao = new Sessao()
                .setNumeroSessao(sessao.getNumeroSessao() + 1)
                .setDataHoraInicio(inicioProximaSessao)
                .setDataHoraFim(fimProximaSessao);
        return proximaSessao;
    }

}
