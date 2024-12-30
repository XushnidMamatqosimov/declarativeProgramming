package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> square = num -> num*num;
        System.out.println(square.apply(4));
    }
}
