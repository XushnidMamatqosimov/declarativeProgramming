package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> printDetails = (name, age) -> System.out.println(name + " " + age + " yoshda");
        printDetails.accept("Xushnid", 19);

    }
}
