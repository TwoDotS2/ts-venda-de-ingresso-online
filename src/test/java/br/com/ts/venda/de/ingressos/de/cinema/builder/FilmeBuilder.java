package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Filme;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaFilme;

public class FilmeBuilder {
    private String nome;
    private Integer faixaEtaria;
    private String descricao;
    private CategoriaFilme categoria;
    private Integer duracaoEmMinutos;

    public static FilmeBuilder umFilme() {
        return new FilmeBuilder();
    }

    public FilmeBuilder comName(String nome) {
        this.nome = nome;
        return this;
    }

    public FilmeBuilder comFaixaEtaria(Integer faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
        return this;
    }

    public FilmeBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public FilmeBuilder comCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
        return this;
    }

    public FilmeBuilder comDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
        return this;
    }

    public Filme build() {
        return new Filme(nome, faixaEtaria, descricao, categoria, duracaoEmMinutos);
    }

    public String nome() {
        return nome;
    }

    public Integer faixaEtaria() {
        return faixaEtaria;
    }

    public String descricao() {
        return descricao;
    }

    public CategoriaFilme categoria() {
        return categoria;
    }

    public Integer duracaoEmMinutos() {
        return duracaoEmMinutos;
    }
}
