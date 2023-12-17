package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.builder.SalaBuilder;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.List;

public class Sala {
    private Integer numeroSala;
    private TipoSala tipoSala;
    private Integer quantidadeFileiras;
    private Integer quantidadeColunas;
    private List<String> assentos;
    private List<String> assentosIndisponiveis;
    private List<String> assentosDBOX;

    public Sala(SalaBuilder builder) {
        this.numeroSala = builder.numeroSala();
        this.tipoSala = builder.tipoSala();
        this.quantidadeFileiras = builder.quantidadeFileiras();
        this.quantidadeColunas = builder.quantidadeColunas();
        this.assentos = builder.assentos();
        this.assentosIndisponiveis = builder.assentosIndisponiveis();
        this.assentosDBOX = builder.assentosDBOX();
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public Integer getQuantidadeFileiras() {
        return quantidadeFileiras;
    }

    public void setQuantidadeFileiras(Integer quantidadeFileiras) {
        this.quantidadeFileiras = quantidadeFileiras;
    }

    public Integer getQuantidadeColunas() {
        return quantidadeColunas;
    }

    public void setQuantidadeColunas(Integer quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
    }

    public List<String> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<String> assentos) {
        this.assentos = assentos;
    }

    public List<String> getAssentosIndisponiveis() {
        return assentosIndisponiveis;
    }

    public void setAssentosIndisponiveis(List<String> assentosIndisponiveis) {
        this.assentosIndisponiveis = assentosIndisponiveis;
    }

    public List<String> getAssentosDBOX() {
        return assentosDBOX;
    }

    public void setAssentosDBOX(List<String> assentosDBOX) {
        this.assentosDBOX = assentosDBOX;
    }

}
