package br.com.ts.venda.de.ingressos.de.cinema.entidades;

public class Ingresso {
    private Sessao sessao;
    private Cliente cliente;
    private float preco;
    private String codigoAssento;

    public Ingresso(Sessao sessao, Cliente cliente, float preco, String codigoAssento) {
        this.sessao = sessao;
        this.cliente = cliente;
        this.preco = preco;
        this.codigoAssento = codigoAssento;
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
