package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Filme;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sessao;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class SessaoBuilder {
    private LocalTime horario;
    private LocalDate data;
    private Sala sala;
    private Filme filme;
    private TipoDia tipoDia;
    private Map<String, Cliente> assentosOcupados;

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

    public SessaoBuilder comAssentosOcupados(Map<String, Cliente> assentosOcupados) {
        this.assentosOcupados = new HashMap<>(assentosOcupados);
        return this;
    }

    public SessaoBuilder adicionarAssentoOcupado(String assento, Cliente cliente) {
        if (this.assentosOcupados == null) {
            this.assentosOcupados = new HashMap<>();
        }
        this.assentosOcupados.put(assento, cliente);
        return this;
    }

    public Sessao build() {
        return new Sessao(horario, data, sala, filme, tipoDia, assentosOcupados);
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

    public Map<String, Cliente> assentosOcupados() {
        return assentosOcupados;
    }
}
