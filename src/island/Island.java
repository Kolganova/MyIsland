package island;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Island {
    private static Island ISLAND;
    private final String name;
    private final int width;
    private final int length;
    private final CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations
            = new CopyOnWriteArrayList<>();

    private static final AtomicInteger amountOfAnimals = new AtomicInteger();
    private static final AtomicInteger amountOfPlants = new AtomicInteger();
    private static final AtomicInteger amountOfDeadAnimals = new AtomicInteger();

    private Island(int width, int length, String name) {
        this.width = width;
        this.length = length;
        this.name = name;
        setListOfLocations();
    }

    private void setListOfLocations() {
        for (int i = 0; i < width; i++) {
            CopyOnWriteArrayList<Location> list = new CopyOnWriteArrayList<>();
            listOfLocations.add(list);
            setLocationToList(list, i);
        }
    }

        private void setLocationToList(CopyOnWriteArrayList<Location> list, int index) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        for (int i = 0; i < length; i++) {
            int finalI = i;
            completionService.submit(() -> {
                Location location = new Location();
                location.setIndexOfExternalList(index);
                location.setIndexOfInnerList(finalI);
                list.add(location);
                location.primaryAnimalsCreator();
                return null;
            });
        }

        try {
            for (int i = 0; i < length; i++) {
                completionService.take().get();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }


    public CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> getListOfLocations() {
        return listOfLocations;
    }

    public static AtomicInteger getAmountOfAnimals() {
        return amountOfAnimals;
    }

    public static AtomicInteger getAmountOfPlants() {
        return amountOfPlants;
    }

    public static AtomicInteger getAmountOfDeadAnimals() {
        return amountOfDeadAnimals;
    }

    public static void incrementAmountOfAnimals() {
        amountOfAnimals.getAndIncrement();
    }
    public static void incrementAmountOfPlants() {
        amountOfPlants.getAndIncrement();
    }
    public static void incrementAmountOfDeadAnimals() {
        amountOfDeadAnimals.getAndIncrement();
    }

    public static void decrementAmountOfAnimals(){
        amountOfAnimals.getAndDecrement();
    }
    public static void decrementAmountOfPlants(){
        amountOfPlants.getAndDecrement();
    }
    public static void decrementAmountOfDeadAnimals(){
        amountOfDeadAnimals.getAndDecrement();
    }

    public String getName() {
        return name;
    }

    public static Island getIsland() {
        if (ISLAND == null) {
            ISLAND = new Island(10, 50, "DangerousIsland");
        }

        return ISLAND;
    }
}
