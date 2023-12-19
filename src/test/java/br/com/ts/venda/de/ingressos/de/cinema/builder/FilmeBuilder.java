package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Filme;
import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaFilme;
import br.com.ts.venda.de.ingressos.de.cinema.enums.ClassificacaoIndicativa;

public class FilmeBuilder {
    private String nome = "Toy Story";
    private ClassificacaoIndicativa faixaEtaria = ClassificacaoIndicativa.LIVRE;
    private String descricao = "Brinquedos vivem";
    private CategoriaFilme categoria = CategoriaFilme.ANIMACAO;
    private Integer duracaoEmMinutos = 77;

    public static FilmeBuilder umFilme() {
        return new FilmeBuilder();
    }

    public FilmeBuilder comName(String nome) {
        this.nome = nome;
        return this;
    }

    public FilmeBuilder comFaixaEtaria(ClassificacaoIndicativa faixaEtaria) {
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
}
