package uz.pdp.behaviorparametezization.selfImprovement;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Worker> workerList = List.of(
                new Worker("Xushnid", "UZB", "Java-Dev", 19),
                new Worker("Xislat", "USA", "Java-Dev", 17),
                new Worker("Humoyun", "USA", "Go-Dev", 27),
                new Worker("HojiAkbar", "UZB", "Go-Dev", 35),
                new Worker("Xasan", "Rus", "Python-Dev", 43)
        );
        List<Worker> workerBy = getWorkerBy(workerList, new WorkerFilerByAge(20));
        System.out.println(workerBy);
        List<Worker> workerByPosition= getWorkerBy(workerList, new WorkerFilterByPosition("Java-Dev"));
        System.out.println(workerByPosition);
        List<Worker> workerByCountry = getWorkerBy(workerList, new WorkerFilterByCountry("usa"));
        System.out.println(workerByCountry);
        List<Worker> workerByRussian = getWorkerBy(workerList, new WorkerFilterByCountry("ruS"));
        System.out.println(workerByRussian);

    }
    public static List<Worker> getWorkerBy(List <Worker> workerList, Filter filter){
        List<Worker> workers = new ArrayList<>();
        for (Worker worker : workerList) {
            if (filter.test(worker)){
                workers.add(worker);
            }
        }
        return workers;
    }

}
