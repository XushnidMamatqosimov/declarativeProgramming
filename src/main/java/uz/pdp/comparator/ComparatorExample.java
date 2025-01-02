package uz.pdp.comparator;

import com.google.gson.Gson;
import uz.pdp.lambdaExpression.Ishchi;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.stream;

public class ComparatorExample {
    public static void main(String[] args) throws IOException {
       /* Function<String, Integer> comparingKey = element -> element.length();
        Stream.of("grapes", "milk", "berry", "pineapple", "water-melon", "apple")
                .sorted(Comparator.comparing(comparingKey, Comparator.reverseOrder()))
                .forEach(System.out::println);*/


       /* ToIntFunction<Integer> keyExtractor = i -> Math.abs(i);
        Stream.of(-10, 31, 16, -5, 2)
                .sorted(Comparator.comparingInt(keyExtractor))
                .forEach(System.out::println);*/

        Path path = Path.of("src/main/resources/employee.json");
        String string = Files.readString(path);
        Type type = new TypeToken<List<Ishchi>>() {
        }.getType();
        Gson fromGson = new Gson();
        List<Ishchi> employees = fromGson.fromJson(string, type);
        employees.stream()
                .sorted(Comparator
                        .comparing(Ishchi::getFull_name)
                        .thenComparing(Ishchi::getGender)
                        .thenComparing(Ishchi::getAge)
                )
                .forEach(System.out::println);

    }
}
