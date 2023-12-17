package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.List;

public class SalaBuilder {
    private Integer numeroSala;
    private TipoSala tipoSala;
    private Integer quantidadeFileiras;
    private Integer quantidadeColunas;
    private List<String> assentos;
    private List<String> assentosIndisponiveis;
    private List<String> assentosDBOX;

    public static SalaBuilder umaSala() {
        return new SalaBuilder();
    }

    public SalaBuilder comNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
        return this;
    }

    public SalaBuilder comTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
        return this;
    }

    public SalaBuilder comQuantidadeFileiras(Integer quantidadeFileiras) {
        this.quantidadeFileiras = quantidadeFileiras;
        return this;
    }

    public SalaBuilder comQuantidadeColunas(Integer quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
        return this;
    }

    public SalaBuilder comAssentos(List<String> assentos) {
        this.assentos = assentos;
        return this;
    }

    public SalaBuilder comAssentosIndisponiveis(List<String> assentosIndisponiveis) {
        this.assentosIndisponiveis = assentosIndisponiveis;
        return this;
    }

    public SalaBuilder comAssentosDBOX(List<String> assentosDBOX) {
        this.assentosDBOX = assentosDBOX;
        return this;
    }

    public Sala build() {
        return new Sala(this);
    }

    public Integer numeroSala() {
        return numeroSala;
    }

    public TipoSala tipoSala() {
        return tipoSala;
    }

    public Integer quantidadeFileiras() {
        return quantidadeFileiras;
    }

    public Integer quantidadeColunas() {
        return quantidadeColunas;
    }

    public List<String> assentos() {
        return assentos;
    }

    public List<String> assentosIndisponiveis() {
        return assentosIndisponiveis;
    }

    public List<String> assentosDBOX() {
        return assentosDBOX;
    }
}
