package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entities.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.entities.Ingresso;
import br.com.ts.venda.de.ingressos.de.cinema.entities.Sessao;

public class IngressoBuilder {
    private Sessao sessao;
    private Cliente cliente;
    private float preco;
    private String codigoAssento;

    public static IngressoBuilder umIngresso() {
        return new IngressoBuilder();
    }

    public IngressoBuilder comSessao(Sessao sessao) {
        this.sessao = sessao;
        return this;
    }

    public IngressoBuilder comCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public IngressoBuilder comPreco(float preco) {
        this.preco = preco;
        return this;
    }

    public IngressoBuilder comCodigoAssento(String codigoAssento) {
        this.codigoAssento = codigoAssento;
        return this;
    }

    public Ingresso build() {
        return new Ingresso(sessao.getSala().getNumero(), cliente.getCategoria(),
                codigoAssento, sessao.getData(), sessao.getHorario());
    }

    public Sessao sessao() {
        return sessao;
    }

    public Cliente cliente() {
        return cliente;
    }

    public float preco() {
        return preco;
    }

    public String codigoAssento() {
        return codigoAssento;
    }
}
