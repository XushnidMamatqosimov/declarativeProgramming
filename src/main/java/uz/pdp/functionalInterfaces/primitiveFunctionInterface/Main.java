package uz.pdp.functionalInterfaces.primitiveFunctionInterface;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 1000000).toArray();
        BinaryOperator<Integer> f1 = Integer::sum;
        IntBinaryOperator f2 = Integer::sum;
        RunningTime.calculate(v -> reduceWrapper(arr, f1));
        RunningTime.calculate(v -> reducePrimitive(arr, f2));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}


class RunningTime {
    public static void calculate(Consumer<Void> consumer) {
        long begin = System.currentTimeMillis();
        consumer.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
