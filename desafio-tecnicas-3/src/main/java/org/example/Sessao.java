package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sessao {
    private Integer numeroSessao;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;

    public Integer getNumeroSessao() {
        return numeroSessao;
    }

    public Sessao setNumeroSessao(Integer numeroSessao) {
        this.numeroSessao = numeroSessao;
        return this;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public Sessao setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
        return this;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public Sessao setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Sessao #").append(numeroSessao)
                .append(":\n\tData da Sessao = ")
                .append(dataHoraInicio.format(
                        DateTimeFormatter.ofPattern("dd/MM/yyyy EEEE", Constants.LOCALE)))
                .append("\n\tHorário de início = ")
                .append(dataHoraInicio.atZone(Constants.ZONE_ID).format(
                        DateTimeFormatter.ofPattern("HH:mm dd/MM z (Z)", Constants.LOCALE)))
                .append("\n\tHorário de término = ")
                .append(dataHoraFim.atZone(Constants.ZONE_ID).format(
                        DateTimeFormatter.ofPattern("HH:mm dd/MM z (Z)", Constants.LOCALE)))
                .toString();
    }

}
