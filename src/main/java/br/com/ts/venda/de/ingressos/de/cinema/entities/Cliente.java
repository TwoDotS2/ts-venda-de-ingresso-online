package br.com.ts.venda.de.ingressos.de.cinema.entities;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;

import java.time.LocalDate;
import java.time.LocalTime;

import static java.time.temporal.ChronoUnit.YEARS;

public class Cliente {
    private CategoriaCliente categoria;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String CPF;
    private String endereco;

    public Cliente(CategoriaCliente categoria, LocalDate dataNascimento, String nomeCompleto, String CPF, String endereco) {
        this.categoria = categoria;
        this.dataNascimento = dataNascimento;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public CategoriaCliente getCategoria() {
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

    public long calcularIdade(){
        return YEARS.between(LocalTime.now(), dataNascimento);
    }
}
