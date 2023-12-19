package br.com.ts.venda.de.ingressos.de.cinema.entities;

import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private Integer numero;
    private TipoSala tipoSala;
    private Integer quantidadeFileiras;
    private Integer quantidadeColunas;
    private List<String> assentos;
    private List<String> fileirasAssentosDBOX;

    public Sala(){}

    public Sala(Integer numero, TipoSala tipoSala, Integer quantidadeFileiras, Integer quantidadeColunas,
                List<String> assentos, List<String> fileirasAssentosDBOX) {
        this.numero = numero;
        this.tipoSala = tipoSala;
        this.quantidadeFileiras = quantidadeFileiras;
        this.quantidadeColunas = quantidadeColunas;
        this.assentos = assentos;
        this.fileirasAssentosDBOX = fileirasAssentosDBOX;
    }

    public static List<String> gerarAssentos(Integer quantidadeFileiras, Integer quantidadeColunas){
        List<String> assentos = new ArrayList<>();

        for (char fileira = 'A'; fileira <= 'A' + quantidadeFileiras-1; fileira++) {
            for (int coluna = 1; coluna <= quantidadeColunas; coluna++) {

                String assento = fileira + Integer.toString(coluna);

                assentos.add(assento);
            }
        }

        return assentos;
    }

    public Boolean assentoEhDBOX(String assento){
        String fileira = assento.charAt(0) + "";
        return fileirasAssentosDBOX.contains(fileira);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    public Integer getQuantidadeFileiras() {
        return quantidadeFileiras;
    }

    public void setQuantidadeFileiras(Integer quantidadeFileiras) {
        this.quantidadeFileiras = quantidadeFileiras;
    }

    public Integer getQuantidadeColunas() {
        return quantidadeColunas;
    }

    public void setQuantidadeColunas(Integer quantidadeColunas) {
        this.quantidadeColunas = quantidadeColunas;
    }

    public List<String> getAssentos() {
        return assentos;
    }

    public void setAssentos(List<String> assentos) {
        this.assentos = assentos;
    }

    public List<String> getFileirasAssentosDBOX() {
        return fileirasAssentosDBOX;
    }

    public void setFileirasAssentosDBOX(List<String> fileirasAssentosDBOX) {
        this.fileirasAssentosDBOX = fileirasAssentosDBOX;
    }

}
