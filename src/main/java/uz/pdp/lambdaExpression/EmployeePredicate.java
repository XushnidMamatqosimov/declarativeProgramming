package uz.pdp.lambdaExpression;

import java.util.Objects;

@FunctionalInterface
public interface EmployeePredicate {
    boolean test(Object o);
   // boolean testA(Object object);

}
