package br.com.ts.venda.de.ingressos.de.cinema.entidades;

import br.com.ts.venda.de.ingressos.de.cinema.enums.CategoriaFilme;
import br.com.ts.venda.de.ingressos.de.cinema.enums.ClassificacaoIndicativa;

public class Filme {
    private String nome;
    private ClassificacaoIndicativa faixaEtaria;
    private String descricao;
    private CategoriaFilme categoria;
    private Integer duracaoEmMinutos;

    public Filme(String nome, ClassificacaoIndicativa faixaEtaria, String descricao, CategoriaFilme categoria, Integer duracaoEmMinutos) {
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
        this.descricao = descricao;
        this.categoria = categoria;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public ClassificacaoIndicativa faixaEtaria() {
        return faixaEtaria;
    }

    @Override
    public String toString() {
        return "\n\t Filme{" +
                "\n\t\t nome='" + nome +
                "\n\t\t faixaEtaria=" + faixaEtaria +
                "\n\t\t descricao='" + descricao +
                "\n\t\t categoria=" + categoria.name() +
                "\n\t\t duracaoEmMinutos=" + duracaoEmMinutos +
                "\n\t }";
    }
}
