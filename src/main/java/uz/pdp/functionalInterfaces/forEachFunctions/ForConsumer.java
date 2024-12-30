package uz.pdp.functionalInterfaces.forEachFunctions;

import java.util.function.Consumer;

public class ForConsumer {
    public static void main(String[] args) {
        Consumer<String> printMessage = msg -> System.out.println(msg);
        printMessage.accept("Salom");
    }
}
