package uz.pdp.behaviorparametezization.selfImprovement;

public class WorkerFilerByAge implements Filter{
    private final Integer age;

    public WorkerFilerByAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean test(Worker worker) {
        return worker.getAge()>age;
    }
}
