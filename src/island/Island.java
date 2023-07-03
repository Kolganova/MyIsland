package island;

import constants.Constant;
import islandOccupants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static islandOccupants.OccupantFactory.createOccupant;

public class Island {
    private final int width;
    private final int length;
    private final CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> listOfLocations
            = new CopyOnWriteArrayList<>();

    public Island(int width, int length) {
        this.width = width;
        this.length = length;
        setListOfLocations();
    }

    public boolean isEndOfIsland(Location location) {
        boolean result = false;
        // придумать логику, как найти именно эту клетку в нашем ебаном списке?
        // как в нашем общем списке найти конкретно эту локацию
        // или просто сделать проверку в самом методе move
        // есть ли такая клетка вообще и все. или сделать эту проверку здесь...

        return result;
    }

    private void setListOfLocations() {
        for (int i = 0; i < width; i++) {
            CopyOnWriteArrayList<Location> list = new CopyOnWriteArrayList<>();
            listOfLocations.add(list);
            setLocationToList(list);
        }
    }

    private void setLocationToList(CopyOnWriteArrayList<Location> list) {
        // работает не многопоточно из-за future.get();
        // но без future вообще зависает. Мб есть deadLock?
        // надо продумать работу программы тщательнее
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Callable<Void>> tasks = new ArrayList<>();
        Runnable runnable = () -> {
            for (AtomicInteger i = new AtomicInteger(); i.get() < length; i.getAndIncrement()) {
                list.add(new Location());
                Location temp = list.get(i.get());
                temp.startAnimalAmountCreator();
            }
        };

        try {
            service.submit(runnable).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        service.shutdown();
    }

    public CopyOnWriteArrayList<CopyOnWriteArrayList<Location>> getListOfLocations() {
        return listOfLocations;
    }

    public static class Location {
        private static final AtomicInteger counter = new AtomicInteger();
        private final CopyOnWriteArrayList<IslandOccupant> listOfOccupants;

        public Location() {
            listOfOccupants = new CopyOnWriteArrayList<>();
        }

        public CopyOnWriteArrayList<IslandOccupant> getListOfOccupants() {
            return listOfOccupants;
        }

        public void addOccupantInLocation(IslandOccupant occupant) {
            listOfOccupants.add(occupant);
        }

        public synchronized void startAnimalAmountCreator() { // название мб поменять
            OccupantFactory.setLocation(this);
            Constant.getListOfOccupantTypes().forEach((key, value) -> {
                int max = Constant.getListOfOccupantTypes().get(key); // AtomicInteger нужно сделать, скорее всего
                for (AtomicInteger i = new AtomicInteger(); i.get() < max; i.getAndIncrement()) {
                    createOccupant(key);
                    counter.getAndIncrement();
                    System.out.println(key + " from add occupant method");
                }
            });
        }

        public static AtomicInteger getCounter() {
            return counter;
        }
    }

}
