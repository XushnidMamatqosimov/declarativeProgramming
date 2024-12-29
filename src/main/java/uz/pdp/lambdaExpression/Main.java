package uz.pdp.lambdaExpression;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class Main {

    /*private Function<Integer, String> func = (i) -> "HELLO";
    private static int a = 123;*/

    public static void main(String[] args) throws Exception {
        //introductionToLambdas();
        Ishchi ishchi = new Ishchi();

       List<Ishchi> newList= List.of(
       );

       // List<Ishchi> uzb = getEmployeesBy(empList, (employee1 -> employee1.getCountry().equals("UZB")));
    }

    public static List<Ishchi> getEmployeesBy(List<Ishchi> employeeList, Filter1 filers) {
        List<Ishchi> employees = new ArrayList<>();
        for (Ishchi emp : employeeList) {
            if (filers.test(emp)) {
                employees.add(emp);
            }
        }
        return employees;
    }

    private static void introductionToLambdas() {
        Callable<Integer> callable = () -> "Hello PDP".length();
        Runnable runnable = () -> {
            int a = 90;
            System.out.println(a);
        };
        runnable.run();
    }
}
