package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.BiFunction;

public class BigFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> multiply = (a,b) -> a*b;
        System.out.println(multiply.apply(4, 5));
    }
}
