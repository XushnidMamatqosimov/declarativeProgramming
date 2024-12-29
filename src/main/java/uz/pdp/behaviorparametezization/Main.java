package uz.pdp.behaviorparametezization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = List.of(
                new Employee("Javohir Elmurodov", "UZB", "SOFTWARE ENGINEER", 28),
                new Employee("John Doe", "US", "MANAGER ", 108),
                new Employee("Akmal Turdiyev", "UZB", "SALES_MANAGER", 29),
                new Employee("John Leg", "GER", "MANAGER", 25),
                new Employee("Akbar Akbarov", "US", "SOFTWARE ENGINEER", 17)
        );
        List<Employee> uzbEmployee = getEmployeesBy(empList, new EmployeeFilterByCountry("UZB"));
        List<Employee> usaEmployee = getEmployeesBy(empList, new EmployeeFilterByCountry("US"));
        List<Employee> employeesByAge= getEmployeesBy(empList, new EmployeeFilterByAge(25));
        List<Employee> manager = getEmployeesBy(empList, new EmployeeFilterByPosition("MANAGER"));
        System.out.println(manager);
        System.out.println(usaEmployee);
        System.out.println(employeesByAge);


       // todo: With lambda
        System.out.println("---------------");
        List<Employee> employeesBy = getEmployeesBy(empList, (employee -> employee.getCountry().equals("UZB")));
        List<Employee> employeesBy1 = getEmployeesBy(empList, (employee -> employee.getPosition().equals("MANAGER")));
        List<Employee> employeesBy2 = getEmployeesBy(empList, (employee -> employee.getAge() > 25));
        System.out.println(employeesBy);
        System.out.println(employeesBy1);
        System.out.println(employeesBy2);

    }

    private static List<Employee> getEmployeeWhoseAgeGreaterThan25(List<Employee> empList) {
       List<Employee> employees = new ArrayList<>();
        for (Employee employee : empList) {
            if (employee.getAge()>=25){
                employees.add(employee);
            }
        }
        return employees;
    }



    //todo: Asos codemiz, hammasi uchun asosiy begilab beruvchi nimsi boyicha filter qilshni;
    public static List<Employee> getEmployeesBy(List<Employee> employeeList, Filers filers) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (filers.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }
}



// todo: Filter yaratildi;
interface Filers{
    boolean test(Employee employee);
}



class EmployeeFilterByCountry implements Filers{
    private final String country;

    public EmployeeFilterByCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getCountry().equals(country);
    }
}

class EmployeeFilterByAge implements Filers{
    private final int age;

    public EmployeeFilterByAge(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getAge()>age;
    }

}

class EmployeeFilterByPosition implements Filers{
    private final String positon;

    public EmployeeFilterByPosition(String positon) {
        this.positon = positon;
    }

    @Override
    public boolean test(Employee employee) {
        return employee.getPosition().equals(positon);
    }
}

@Data
@AllArgsConstructor
class Employee {
    private String name;
    private String country;
    private String position;
    private int age;
}
