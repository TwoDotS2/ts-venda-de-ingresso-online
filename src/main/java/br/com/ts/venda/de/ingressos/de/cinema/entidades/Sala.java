package br.com.ts.venda.de.ingressos.de.cinema.entidades;

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

    public Integer numero() {
        return numero;
    }

    public TipoSala tipoSala() {
        return tipoSala;
    }


    @Override
    public String toString() {
        return "\n\t Sala{" +
                "\n\t\t numero=" + numero +
                "\n\t\t tipoSala=" + tipoSala.name() +
                "\n\t\t quantidadeFileiras=" + quantidadeFileiras +
                "\n\t\t quantidadeColunas=" + quantidadeColunas +
                "\n\t\t assentos=" + assentos +
                "\n\t\t fileirasAssentosDBOX=" + fileirasAssentosDBOX.toString() +
                "\n\t }";

  }
}