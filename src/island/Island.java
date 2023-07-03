package island;

import constants.Constant;
import islandOccupants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (AtomicInteger i = new AtomicInteger(); i.get() < length; i.getAndIncrement()) {
                    list.add(new Location());
                    Location temp = list.get(i.get());
                    if (i.get() == length - 1 || i.get() == length - 2)
                        temp.setDesert(true);
                    temp.startAnimalAmountCreator();
                }
            }
        };
//        service.submit(runnable);
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
        private static AtomicInteger counter = new AtomicInteger();
        private final CopyOnWriteArrayList<IslandOccupant> listOfOccupants;
        private boolean isDesert = false;

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
            OccupantFactory factory = new OccupantFactory(this);
            Constant.getListOfOccupantTypes().forEach((key, value) -> {
                int max = Constant.getListOfOccupantTypes().get(key); // AtomicInteger нужно сделать, скорее всего
                for (AtomicInteger i = new AtomicInteger(); i.get() < max; i.getAndIncrement()) {
                    factory.createOccupant(key);
                    counter.getAndIncrement();
                    System.out.println(key + " from add occupant method");
                }
            });
        }

        public boolean isDesert() {
            return isDesert;
        }

        public void setDesert(boolean desert) {
            isDesert = desert;
        }

        public static AtomicInteger getCounter() {
            return counter;
        }

        private class Desert {
            protected void makeADesert() {
                isDesert = true;
            }
        }
    }

}
