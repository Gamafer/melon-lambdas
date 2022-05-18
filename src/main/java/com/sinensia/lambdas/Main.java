package com.sinensia.lambdas;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China")
        );

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        List<Melon> bailan = Filters.filterByType(melons, "Bailan");
        System.out.println("Lista filtrada: ");
        for(Melon m: bailan) {
            System.out.println(m);
        }

        List<Melon> found = Filters.filterByWeight(melons, 1200);
        System.out.println("Lista melones de 1200g: ");
        for(Melon m: found) {
            System.out.println(m);
        }

        System.out.println("Lista melones gac: ");
        List<Melon> gac = Filters.filterMelons(melons, new GacMelonPredicate());
        for(Melon m: gac) {
            System.out.println(m);
        }

        System.out.println("Lista melones pesados: ");
        List<Melon> heavy = Filters.filterMelons(melons, new HeavyMelonPredicate());
        for(Melon m: heavy) {
            System.out.println(m);
        }

        System.out.println("Lista melones super-pesados: ");
        List<Melon> superheavy = Filters.filterMelons(melons, melon -> melon!=null && melon.getWeight()>=6000);
        for(Melon m: superheavy) {
            System.out.println(m);
        }

        System.out.println("Lista melones europeos: ");
        for(Melon m:  Filters.filterMelons(melons, melon -> melon!=null && melon.getOrigin().equalsIgnoreCase("Europe"))) {
            System.out.println(m);
        }

        System.out.println("Lista sandias: ");
        List<Melon> watermelons = Filters.filter(melons, (Melon m)->m.getType().equalsIgnoreCase("watermelon"));
        for(Melon m: watermelons) {
            System.out.println(m);
        }

    }


}
