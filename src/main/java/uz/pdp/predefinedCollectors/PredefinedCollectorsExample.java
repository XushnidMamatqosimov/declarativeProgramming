package uz.pdp.predefinedCollectors;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.lambdaExpression.Ishchi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PredefinedCollectorsExample {
    public static void main(String[] args) throws IOException {
        List<String> stringList = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String::toUpperCase)
                //.toList()
                .collect(Collectors.toList());
        //System.out.println(stringList);

        Set<String> stringSet = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String::toUpperCase)
                //.toList()
                .collect(Collectors.toSet());
        //System.out.println(stringSet);

        TreeSet<String> treeSet = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String::toUpperCase)
                //.toList()
                .collect(Collectors.toCollection(TreeSet::new));
        // System.out.println(treeSet);

        Map<Object, Object> integerMapper = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy", "JaVa")
                .map(String::toUpperCase)
                //.collect(Collectors.toMap(String::toLowerCase, String::length));
                .collect(Collectors.toMap(String::toLowerCase, String::length, (k1, k2) -> k1));
        BiConsumer<Object, Object> objectObjectBiConsumer = (k, v) -> System.out.println(k + "::" + v);
        //integerMapper.forEach(objectObjectBiConsumer);

        String joining = Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .map(String::toUpperCase)
                .collect(Collectors.joining(", ", "[->", "<-]"));
        System.out.println(joining);

        String readString = Files.readString(Path.of("src/main/resources/employee.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Ishchi>>() {
        }.getType();
        List<Ishchi> employees = gson.fromJson(readString, type);

        //todo: Yoshi boyicha groupplash;
       /* Map<Integer, List<Ishchi>> integerListMap = employees.stream()
                .collect(Collectors.groupingBy(ishchi -> ishchi.getAge()));
        integerListMap.forEach((k,v)->{
            System.out.println(k);
            for (Ishchi ishchi : v) {
                System.out.println("\t\t\t"+ishchi);
            }
        });*/

        //todo: GRouppalash with counting, nechta sonni boyicha
        /*Map<Integer, Long> collect = employees.stream()
                .collect(Collectors.groupingBy(ishchi -> ishchi.getAge(), Collectors.counting()));
        collect.forEach((k,v)-> System.out.println(k+" : "+v));*/

        //todo: grouppingnni Partitionning yolli bilan ishlash usuli
       /* Map<Boolean, Long> male = employees.stream()
                .collect(Collectors.partitioningBy(ishchi -> ishchi.getGender().equals("Male"), Collectors.counting()));
        male.forEach((k, v) -> {
            System.out.print("Key is : " + k);
            System.out.println("Value is : " + v);
        });*/

        /*Stream.of("java", ".net", "python", "Scala", "Kotlin", "Groovy")
                .collect(Collectors.reducing((l1,l2)->l1+", "+l2))
                .ifPresentOrElse((res)-> System.out.println(res),
                        ()-> System.out.println("There is not items"));*/


        // todo; Arithmetic and Summarizing Methods;
       /* employees.stream()
                .collect(Collectors.minBy(Comparator.comparing(Ishchi::getAge))).
                ifPresentOrElse((res) -> System.out.println(res), () -> System.out.println("such item not found"));

        Integer collect = employees.stream()
                .collect(Collectors.summingInt(Ishchi::getAge));
        System.out.println(collect);

        Double collect1 = employees.stream()
                .collect(Collectors.averagingDouble(ishchi -> ishchi.getAge()));
        System.out.println(collect1);*/

        // todo; All in one method;
        DoubleSummaryStatistics statistics = employees.stream().
                collect(Collectors.summarizingDouble(ishchi -> ishchi.getAge()));
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getCount() = " + statistics.getCount());
        System.out.println("statistics.getMax() = " + statistics.getMax());
        System.out.println("statistics.getMin() = " + statistics.getMin());

        IntStream range = IntStream.rangeClosed(1,10);
        //IntStream range = IntStream.range(10, 21);
        // range.forEach(System.out::println);
        OptionalDouble average = range.average();
        System.out.println(average.getAsDouble());

    }
}
