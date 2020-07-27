package com.twc.javaBasic;

import com.twc.javaBasic.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericTest {
    @Test
    void should_auto_resolve_generic_method() {
        final String[] words = {"Hello", "Good", "Morning"};
        final String middle = getMiddle(words);
        assertEquals("Good", middle);
    }

    @Test
    void should_specify_a_type_restriction_on_typed_parameters() {
        int minimumInteger = min(new Integer[]{1, 2, 3});
        double minimumReal = min(new Double[]{1.2, 2.2, -1d});

        assertEquals(1, minimumInteger);
        assertEquals(-1d, minimumReal, 1.0E-05);
    }

    @Test
    void should_swap() {
        Pair<String> pair = new Pair<>("Hello", "World");

        swap(pair);

        assertEquals("World", pair.getFirst());
        assertEquals("Hello", pair.getSecond());
    }

    private static <T> T getMiddle(T[] args) {
        return args[args.length / 2];
    }

    private static <T extends Number & Comparable<T>> T min(T[] values) {
        if (values.length == 0) {
            return null;
        }
        T minValue = values[0];
        for (int i = 1; i < values.length; i++) {
            if (minValue.compareTo(values[i]) > 0) {
                minValue = values[i];
            }
        }
        return minValue;

    }

    private static <T> void swap(Pair<T> pair) {
        T t = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(t);
    }

}
