package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class Sessao {
    private LocalTime horario;
    private LocalDate data;
    private Sala sala;
    private Filme filme;
    private TipoDia tipoDia;

    public Sessao(LocalTime horario, LocalDate data, Sala sala, Filme filme, TipoDia tipoDia) {
        this.horario = horario;
        this.data = data;
        this.sala = sala;
        this.filme = filme;
        this.tipoDia = tipoDia;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public TipoDia getTipoDia() {
        return tipoDia;
    }

    public void setTipoDia(TipoDia tipoDia) {
        this.tipoDia = tipoDia;
    }
}
