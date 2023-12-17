package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Cliente;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;

import java.time.LocalDate;

public class ClienteBuilder {
    private CategoriaCliente categoria;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String CPF;
    private String endereco;

    public static ClienteBuilder umCliente(){ return new ClienteBuilder(); }

    public ClienteBuilder comCategoria(CategoriaCliente categoria){
        this.categoria = categoria;
        return this;
    }

    public ClienteBuilder comDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
        return this;
    }

    public ClienteBuilder comNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public ClienteBuilder comCPF(String CPF) {
        this.CPF = CPF;
        return this;
    }

    public ClienteBuilder comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }


    public Cliente build() {
        return new Cliente(categoria, dataNascimento, nomeCompleto, CPF, endereco);
    }

    public CategoriaCliente categoria() {
        return categoria;
    }

    public LocalDate dataNascimento() {
        return dataNascimento;
    }

    public String nomeCompleto() {
        return nomeCompleto;
    }

    public String CPF() {
        return CPF;
    }

    public String endereco() {
        return endereco;
    }
}
