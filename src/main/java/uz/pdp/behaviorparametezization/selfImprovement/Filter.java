package uz.pdp.behaviorparametezization.selfImprovement;
@FunctionalInterface
public interface Filter {
    boolean test(Worker worker);
}
