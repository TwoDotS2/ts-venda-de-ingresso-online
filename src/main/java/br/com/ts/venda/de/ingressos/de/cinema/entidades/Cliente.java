package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaCliente;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class Cliente {
    private CategoriaCliente categoria;
    private LocalDate dataNascimento;
    private String nomeCompleto;
    private String CPF;
    private String endereco;

    public Cliente(){};

    public Cliente(CategoriaCliente categoria, LocalDate dataNascimento, String nomeCompleto, String CPF, String endereco) {
        this.categoria = categoria;
        this.dataNascimento = dataNascimento;
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public CategoriaCliente categoria() {
        return categoria;
    }

    public long calcularIdade(){
        return YEARS.between(dataNascimento, LocalDate.now());
    }

    @Override
    public String toString() {
        return "\n\t Cliente{" +
                "\n\t\t categoria=" + categoria.name() +
                "\n\t\t dataNascimento=" + dataNascimento +
                "\n\t\t nomeCompleto='" + nomeCompleto +
                "\n\t\t CPF='" + CPF +
                "\n\t\t endereco='" + endereco +
                "\n\t}";
    }
}
