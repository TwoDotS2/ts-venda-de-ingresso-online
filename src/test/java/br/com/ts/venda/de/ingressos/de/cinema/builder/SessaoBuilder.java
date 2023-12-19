package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.*;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class SessaoBuilder {
    private LocalTime horario = LocalTime.now();
    private LocalDate data = LocalDate.now();
    private Sala sala = new SalaBuilder().build();
    private Filme filme = new FilmeBuilder().build();
    private TipoDia tipoDia = TipoDia.QUINTA;

    public static SessaoBuilder umaSessao() {
        return new SessaoBuilder();
    }

    public SessaoBuilder comHorario(LocalTime horario) {
        this.horario = horario;
        return this;
    }

    public SessaoBuilder comData(LocalDate data) {
        this.data = data;
        return this;
    }

    public SessaoBuilder comSala(Sala sala) {
        this.sala = sala;
        return this;
    }

    public SessaoBuilder comFilme(Filme filme) {
        this.filme = filme;
        return this;
    }

    public SessaoBuilder comTipoDia(TipoDia tipoDia) {
        this.tipoDia = tipoDia;
        return this;
    }

    public SessaoBuilder comDiaDeterminandoTipoDia(LocalDate data) {
        switch(data.getDayOfWeek()){
            case MONDAY -> this.tipoDia = TipoDia.SEGUNDA;
            case TUESDAY -> this.tipoDia = TipoDia.TERCA;
            case WEDNESDAY -> this.tipoDia = TipoDia.QUARTA;
            case THURSDAY -> this.tipoDia = TipoDia.QUINTA;
            case FRIDAY -> this.tipoDia = TipoDia.SEXTA;
            case SATURDAY -> this.tipoDia = TipoDia.SABADO;
            case SUNDAY -> this.tipoDia = TipoDia.DOMINGO;
        };
        return this;
    }

    public Sessao build() {
        return new Sessao(horario, data, sala, filme, tipoDia);
    }
}
