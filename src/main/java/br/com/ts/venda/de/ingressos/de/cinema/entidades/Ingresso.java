package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.builder.IngressoBuilder;

public class Ingresso {
    private Sessao sessao;
    private Cliente cliente;
    private float preco;
    private String codigoAssento;

    public Ingresso(IngressoBuilder builder) {
        this.sessao = builder.sessao();
        this.cliente = builder.cliente();
        this.preco = builder.preco();
        this.codigoAssento = builder.codigoAssento();
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getCodigoAssento() {
        return codigoAssento;
    }

    public void setCodigoAssento(String codigoAssento) {
        this.codigoAssento = codigoAssento;
    }
}
