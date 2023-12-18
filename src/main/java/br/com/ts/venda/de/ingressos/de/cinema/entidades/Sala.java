package br.com.ts.venda.de.ingressos.de.cinema.entidades;

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

    public Sala(Integer numeroSala, TipoSala tipoSala, Integer quantidadeFileiras, Integer quantidadeColunas,
                List<String> assentos, List<String> assentosIndisponiveis, List<String> assentosDBOX) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.quantidadeFileiras = quantidadeFileiras;
        this.quantidadeColunas = quantidadeColunas;
        this.assentos = assentos;
        this.assentosIndisponiveis = assentosIndisponiveis;
        this.assentosDBOX = assentosDBOX;
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
