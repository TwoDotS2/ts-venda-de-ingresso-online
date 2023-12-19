package br.com.ts.venda.de.ingressos.de.cinema.entities;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ingresso {
    private long numeroSala;
    private CategoriaCliente categoriaCliente;
    private String codigoAssento;
    private LocalDate diaSessao;
    private LocalTime horarioSessao;

    public Ingresso(long numeroSala, CategoriaCliente categoriaCliente, String codigoAssento, LocalDate diaSessao, LocalTime horarioSessao) {
        this.numeroSala = numeroSala;
        this.categoriaCliente = categoriaCliente;
        this.codigoAssento = codigoAssento;
        this.diaSessao = diaSessao;
        this.horarioSessao = horarioSessao;
    }
}

