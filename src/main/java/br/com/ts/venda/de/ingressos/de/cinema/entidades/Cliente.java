package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.builder.ClienteBuilder;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;

import java.time.LocalDate;

public class Cliente {
    private CategoriaCliente categoria;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String CPF;
    private String endereco;

    public Cliente(ClienteBuilder builder) {
        this.categoria = builder.categoria();
        this.dataNascimento = builder.dataNascimento();
        this.nomeCompleto = builder.nomeCompleto();
        this.CPF = builder.CPF();
        this.endereco = builder.endereco();
    }

    public CategoriaCliente getCategoriaCliente() {
        return categoria;
    }

    public void setCategoriaCliente(CategoriaCliente categoria) {
        this.categoria = categoria;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
