package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.Function;

public class ForFunction {
    public static void main(String[] args) {
        Function<Integer, String> intToString = num -> "Son: "+num;
        System.out.println(intToString.apply(12));
    }
}
