package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.List;

public final class  Filters {
    public Filters() {
        throw new AssertionError("Utility class can not be instantiated");
    }

    public static List<Melon> filterByType(List<Melon> melons, String type) {
        if(melons == null || type ==null) {
            throw new IllegalArgumentException("Melons/type cannot be null");
        }
        if(melons.isEmpty()) {
            return melons;
        }
        List<Melon> result = new ArrayList<>();
        for(Melon melon : melons) {
            if(melon!=null && type.equalsIgnoreCase(melon.getType())) {
                result.add(melon);
            }
        }
        return result;
    }

    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {
        if (melons == null) {
            throw new IllegalArgumentException("Melons cannot be null");
        }

        if (melons.isEmpty() || weight <= 0) {
            return melons;
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons) {
            if (melon != null && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }

    public static List<Melon> filterMelons(List<Melon> melons, MelonPredicate predicate) {
        if(melons==null) {
            throw new IllegalArgumentException("Melons cannot be null");
        }
        List<Melon> result = new ArrayList<>();
        for(Melon melon: melons) {
            if(melon!=null && predicate.test(melon)) {
                result.add(melon);
            }
        }
        return result;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        if(list==null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        List<T> result = new ArrayList<>();
        for(T t: list) {
            if(t!=null && predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
