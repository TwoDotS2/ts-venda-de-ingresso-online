package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.HashMap;

public class Sala {
    private Integer numeroSala;
    private TipoSala tipoSala;
    private HashMap<String, Assento> assentos;

    public Sala(Integer numeroSala, TipoSala tipoSala, HashMap<String, Assento> assentos) {
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
        this.assentos = assentos;
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

    public HashMap<String, Assento> getAssentos() {
        return assentos;
    }

    public void setAssentos(HashMap<String, Assento> assentos) {
        this.assentos = assentos;
    }
}
