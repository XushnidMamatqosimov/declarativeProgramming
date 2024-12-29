package uz.pdp.behaviorparametezization.selfImprovement;

public class WorkerFilterByPosition implements Filter{
    private final String position;

    public WorkerFilterByPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean test(Worker worker) {
        return worker.getPosition().equals(position);
    }
}
