package br.com.ts.venda.de.ingressos.de.cinema.builder;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento;
import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala;
import br.com.ts.venda.de.ingressos.de.cinema.enums.TipoSala;

import java.util.HashMap;

public class SalaBuilder {
    private Integer numeroSala = 1;
    private TipoSala tipoSala = TipoSala._2D;
    private HashMap<String, Assento> assentos = geraAssentos();

    public static SalaBuilder umaSala() {
        return new SalaBuilder();
    }

    public SalaBuilder comNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
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

    public SalaBuilder comAssentoOcupado(String cadeira) {
        adicionaCadeiraOcupada(cadeira);
        return this;
    }

    public Sala build() {
        return new Sala(numeroSala, tipoSala, assentos);
    }

    public HashMap<String, Assento> geraAssentos() {
        HashMap<String, Assento> assentosGerados = new HashMap<>();
        for (int i = 1; i < 28; i++) {
            if (i > 3) {
                assentosGerados.put("C" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("C" + i, false, true, null));
                assentosGerados.put("F" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("F" + i, false, true, null));
                assentosGerados.put("G" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("G" + i, false, true, null));
                if (i > 5 && i < 17) {
                    assentosGerados.put("D" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("D" + i, true, true, null));
                    assentosGerados.put("E" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("E" + i, true, true, null));
                } else {
                    assentosGerados.put("D" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("D" + i, false, true, null));
                    assentosGerados.put("E" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("E" + i, false, true, null));
                }
            }
            if (i < 22) {
                assentosGerados.put("B" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("B" + i, false, true, null));
            }
            assentosGerados.put("A" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("A" + i, false, true, null));
            assentosGerados.put("H" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("H" + i, false, true, null));
            assentosGerados.put("I" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("I" + i, false, true, null));
            assentosGerados.put("J" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("J" + i, false, true, null));
            assentosGerados.put("K" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("K" + i, false, true, null));
            assentosGerados.put("L" + i, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("L" + i, false, true, null));
        }
        ;
        for (int j = 29; j < 33; j++) {
            assentosGerados.put("L" + j, new br.com.ts.venda.de.ingressos.de.cinema.entidades.Assento("L" + j, false, true, null));
        }
        return assentosGerados;
    }

    public void adicionaCadeiraOcupada(String fileira) {
        if (assentos.containsKey(fileira)) {
            assentos.put(fileira, new Assento(fileira, false, false, null));
        } else {
            throw new IllegalArgumentException("Cadeira não existe. Cheque o que foi digitado");
        }
    }
}
