package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoBeneficio;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.time.LocalDate;
import java.time.LocalTime;

import static br.com.ts.venda.de.ingressos.de.cinema.enums.TipoDia.*;
import static java.lang.constant.ConstantDescs.NULL;

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
