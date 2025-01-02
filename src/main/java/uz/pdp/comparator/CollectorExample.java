package uz.pdp.comparator;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import uz.pdp.lambdaExpression.Ishchi;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CollectorExample {
    public static void main(String[] args) throws IOException {
        String readString = Files.readString(Path.of("src/main/resources/employee.json"));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Ishchi>>() {
        }.getType();
        List<Ishchi> employees = gson.fromJson(readString, type);
        String xml = employees.stream()
                .collect(new ToXMLCollector());
        System.out.println(xml);
    }
}

class ToXMLCollector implements Collector<Ishchi, StringBuffer, String> {

    final String xmlstr = """
            \n\t<employee id='%s'>
            \t\t<name>%s</name>
            \t\t<gender>%s</gender>
            \t\t<age>%s</age>
            \t</employee>""";

    public Supplier<StringBuffer> supplier() {
        return StringBuffer::new;
    }

    public BiConsumer<StringBuffer, Ishchi> accumulator() {
        return (sb, e) -> sb.append(String.format(xmlstr, e.getId(), e.getFull_name(), e.getGender(), e.getAge()));
    }

    public BinaryOperator<StringBuffer> combiner() {
        return (sb1, sb2) -> sb1.append(sb2.toString());
    }

    public Function<StringBuffer, String> finisher() {
        return sb -> String.format("<employees>%s\n</employees>", sb.toString());
    }

    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }

}

