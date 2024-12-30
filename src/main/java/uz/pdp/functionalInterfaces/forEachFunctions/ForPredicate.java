package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.Predicate;

public class ForPredicate {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = num -> num > 0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-4));
        Predicate<Integer> isNegative = num ->num<0;
        System.out.println(isNegative.test(5));
        System.out.println(isNegative.test(-4));
    }
}
