package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Ingresso;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sessao;

public class IngressoBuilder {
    private Sessao sessao = new SessaoBuilder().build();
    private Cliente cliente = new ClienteBuilder().build();
    private float preco = 100;
    private String codigoAssento = "A1";

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
        return new Ingresso(sessao, cliente, preco, codigoAssento);
    }
}
