package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.Random;
import java.util.function.Supplier;

public class ForSupply {
    public static void main(String[] args) {
        Supplier<Double> randomValue =() -> Math.random()*10;
        System.out.println(randomValue.get());

    }
}
