package uz.pdp.behaviorparametezization.selfImprovement;

public class WorkerFilterByCountry implements Filter{
    private final String country;

    public WorkerFilterByCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean test(Worker worker) {
        return worker.getCountry().equalsIgnoreCase(country);
    }
}
