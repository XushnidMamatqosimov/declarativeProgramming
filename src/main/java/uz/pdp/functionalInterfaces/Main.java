package uz.pdp.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;

import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {


    }
}

class PredicateTest {
    public static void main(String[] args) {
        int[] array = {45, 4, 8, -3, -4, 10};
        Predicate<Integer> odd = (number) -> number % 2 != 0;
        System.out.println(filter(array, odd));

        Predicate<Integer> even = (number) -> number % 2 == 0;
        System.out.println(filter(array,even));

        Predicate<Integer> negative = (number) -> number < 0;
        System.out.println(filter(array,negative));

        Predicate<Integer> negativeAndEven = negative.and(even);
        System.out.println(filter(array,negativeAndEven));

        Predicate<Integer> negativeAndOdd = negative.or(odd);
        System.out.println(filter(array,negativeAndOdd));


    }

    public static List<Integer> filter(int[] array, Predicate<Integer> predicate) {
        List<Integer> numbers = new ArrayList<>();
        for (int i : array) {
            if (predicate.test(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }
}

