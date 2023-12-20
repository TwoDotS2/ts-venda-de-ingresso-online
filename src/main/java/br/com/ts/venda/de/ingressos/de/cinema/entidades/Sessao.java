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
    private Map<String, Cliente> assentosOcupados;

    public Sessao(LocalTime horario, LocalDate data, Sala sala, Filme filme, TipoDia tipoDia, Map<String, Cliente> assentosOcupados) {
        this.horario = horario;
        this.data = data;
        this.sala = sala;
        this.filme = filme;
        this.tipoDia = tipoDia;
        this.assentosOcupados = assentosOcupados;
    }

    public Boolean assentoEstaDisponivel(String assento){
        return !assentosOcupados.containsKey(assento);
    }

    public LocalTime horario() {
        return horario;
    }

    public LocalDate data() {
        return data;
    }

    public Sala sala() {
        return sala;
    }

    public Filme filme() {
        return filme;
    }

    public TipoDia tipoDia() {
        return tipoDia;
    }

    @Override
    public String toString() {
        return "\n\t Sessao{" +
                "\n\t\t horario=" + horario +
                "\n\t\t data=" + data +
                "\n\t\t sala=" + sala.toString() +
                "\n\t\t filme=" + filme.toString() +
                "\n\t\t tipoDia=" + tipoDia.name() +
                "\n\t\t assentosOcupados=" + assentosOcupados.toString() +
                "\n\t }";
    }
}
