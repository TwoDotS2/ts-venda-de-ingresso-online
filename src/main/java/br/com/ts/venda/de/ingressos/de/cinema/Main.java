package br.com.ts.venda.de.ingressos.de.cinema;

import br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static br.com.ts.venda.de.ingressos.de.cinema.entidades.Sala.gerarAssentos;

public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        sala.setAssentos(gerarAssentos(3, 3));

        List<String> DBOX = new ArrayList<String>();

        DBOX.add("A");
        DBOX.add("B");
        sala.setFileirasAssentosDBOX(DBOX);

        System.out.println(sala.assentoEhDBOX("C1"));
        System.out.println(sala.assentoEhDBOX("A23"));

    }
}
