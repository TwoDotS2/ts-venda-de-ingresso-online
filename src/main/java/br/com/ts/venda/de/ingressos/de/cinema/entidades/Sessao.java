package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.builder.SessaoBuilder;
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
    private Map<String, Cliente> assentosOcupados;

    public Sessao(SessaoBuilder builder) {
        this.horario = builder.horario();
        this.data = builder.data();
        this.sala = builder.sala();
        this.filme = builder.filme();
        this.tipoDia = builder.tipoDia();
        this.assentosOcupados = builder.assentosOcupados();
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

    public Map<String, Cliente> getAssentosOcupados() {
        return assentosOcupados;
    }

    public void setAssentosOcupados(Map<String, Cliente> assentosOcupados) {
        this.assentosOcupados = assentosOcupados;
    }
}
