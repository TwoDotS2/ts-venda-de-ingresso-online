package br.com.ts.venda.de.ingressos.de.cinema;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("A1");
        names.add("B1");
        names.add("C1");
        names.add("C2");
        names.add("A3");
        names.add("B2");

        Comparator<String> cmp = Comparator.naturalOrder();
        Collections.sort(names, cmp);

        for(String name: names){
            System.out.println(name);
        }
        System.out.println(LocalTime.now().plusHours(2));
    }
}
