package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.builder.FilmeBuilder;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaFilme;

public class Filme {
    private String nome;
    private Integer faixaEtaria;
    private String descricao;
    private CategoriaFilme categoria;
    private Integer duracaoEmMinutos;

    public Filme(FilmeBuilder builder) {
        this.nome = builder.nome();
        this.faixaEtaria = builder.faixaEtaria();
        this.descricao = builder.descricao();
        this.categoria = builder.categoria();
        this.duracaoEmMinutos = builder.duracaoEmMinutos();
    }


    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public Integer getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(Integer faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaFilme getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaFilme categoria) {
        this.categoria = categoria;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
}
