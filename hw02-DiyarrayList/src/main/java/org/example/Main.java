package am.hw;

import org.example.DiyArrayList;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> elements = new DiyArrayList<>();
        List<Integer> empty = new DiyArrayList<>();
        Integer[] ints = {654, 654, 654, 654, 654};
        for (int i = 25; i >= 1; i--) {
            elements.add(i);
            empty.add(null);
        }
        Collections.copy(empty, elements);
        System.out.println("Collections copy");
        System.out.println(elements);
        System.out.println(empty);
        System.out.println();

        System.out.println("Collections sort");
        Collections.sort(elements);
        System.out.println(elements);
        System.out.println();

        System.out.println("Collections addAll");
        Collections.addAll(elements, ints);
        System.out.println(elements);
        System.out.println();
    }
}
