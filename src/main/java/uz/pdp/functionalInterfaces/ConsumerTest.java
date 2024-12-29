package uz.pdp.functionalInterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class ConsumerTest {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );
        Consumer<Employee> printOneConsole = (e -> System.out.println(e.toString()));
        Consumer<Employee> storeInDB = (employee -> System.out.println(employee.toString() + " saving to database"));

        //  forEach(empList, printOneConsole);
        //forEach(empList, storeInDB);
        //forEach(empList, printOneConsole.andThen(storeInDB));
        Consumer<Employee> printConsoleAndThenStoreInDB = printOneConsole.andThen(storeInDB);
        forEach(empList, printConsoleAndThenStoreInDB);

    }

    static <T> void forEach(List<T> list, Consumer<T> consumer) {
        int nullCount = 0;
        for (T t : list) {
            if (t != null) {
                consumer.accept(t);
            } else {
                nullCount++;
            }
        }
        System.out.printf("%d null entries count  in the list.\n", nullCount);
    }
}

class FunctionTest{
    public static void main(String[] args) {
        Function<String, Integer> charsCount = (s  )->{
            return s.length();
        };
        Integer helloPdp = charsCount.apply("hello Pdp");
        System.out.println(helloPdp);
    }
}

class SupplierTest{
    public static void main(String[] args) {
        Supplier<Throwable> supplier = ()-> new RuntimeException("Exception occurred");
    }
}

class Employee {
    private String name;
    private String country;
    private String position;
    private int age;

    public Employee(String name, String country, String position, int age) {
        this.name = name;
        this.country = country;
        this.position = position;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                '}';
    }
}

