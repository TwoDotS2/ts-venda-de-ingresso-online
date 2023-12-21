package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.ArrayList;
import java.util.List;

import static br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala.gerarAssentos;

public class SalaBuilder {

    private Integer numero = 1;
    private TipoSala tipoSala = TipoSala._2D;
    private Integer quantidadeFileiras = 20;
    private Integer quantidadeColunas = 10;
    private List<String> assentos = gerarAssentos(quantidadeFileiras, quantidadeColunas);
    private List<String> fileirasAssentosDBOX = new ArrayList<>();

    public static SalaBuilder umaSala() {
        return new SalaBuilder();
    }

    public SalaBuilder comNumero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public SalaBuilder comTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
        return this;
    }

    public SalaBuilder com3d() {
        this.tipoSala = TipoSala._3D;
        return this;
    }

    public SalaBuilder comSalaEspecifica(Integer rows, Integer columns){
        this.quantidadeFileiras = rows;
        this.quantidadeColunas = columns;
        gerarAssentos(quantidadeFileiras, quantidadeColunas);
        return this;
    }


    public SalaBuilder comFileirasAssentosDBOX(List<String> fileirasAssentosDBOX) {
        this.fileirasAssentosDBOX = fileirasAssentosDBOX;
        return this;
    }

    public Sala build() {
        return new Sala(numero, tipoSala,quantidadeFileiras, quantidadeColunas, assentos, fileirasAssentosDBOX);
    }

}
