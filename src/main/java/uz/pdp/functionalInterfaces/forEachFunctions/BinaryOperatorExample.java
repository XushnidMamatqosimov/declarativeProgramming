package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a,b)-> a+b;
        System.out.println(add.apply(2, 3));

    }
}
