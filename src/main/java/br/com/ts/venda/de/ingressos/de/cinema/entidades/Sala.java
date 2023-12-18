package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.List;

public class Sala {
    private Integer numero;
    private TipoSala tipoSala;
    private Integer quantidadeFileiras;
    private Integer quantidadeColunas;
    private List<String> assentos;
    private List<Integer> assentosDBOX;

    public Sala(Integer numero, TipoSala tipoSala, Integer quantidadeFileiras, Integer quantidadeColunas,
                List<String> assentos, List<Integer> assentosDBOX) {
        this.numero = numero;
        this.tipoSala = tipoSala;
        this.quantidadeFileiras = quantidadeFileiras;
        this.quantidadeColunas = quantidadeColunas;
        this.assentos = assentos;
        this.assentosDBOX = assentosDBOX;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
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

    public List<Integer> getAssentosDBOX() {
        return assentosDBOX;
    }

    public void setAssentosDBOX(List<Integer> assentosDBOX) {
        this.assentosDBOX = assentosDBOX;
    }

}
