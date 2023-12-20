package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.*;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SessaoBuilder {
    private LocalTime horario = LocalTime.now();
    private LocalDate data = LocalDate.now();
    private Sala sala = new SalaBuilder().build();
    private Filme filme = new FilmeBuilder().build();
    private TipoDia tipoDia = TipoDia.QUINTA;
    private Map<String, Cliente> assentosOcupados = Map.of("A4", new ClienteBuilder()
            .comCategoria(CategoriaCliente.ESTUDANTE).build(),"A5", new ClienteBuilder()
            .comCategoria(CategoriaCliente.VISITANTE).build());

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

    public SessaoBuilder comAssentosOcupados(String cadeira){
        assentosOcupados.clear();
        assentosOcupados = Map.of(cadeira, new ClienteBuilder()
                .comCategoria(CategoriaCliente.ESTUDANTE).build());
        return this;
    }

    public Sessao build() {
        return new Sessao(horario, data, sala, filme, tipoDia, assentosOcupados);
    }
}
