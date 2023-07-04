package island;

import islandOccupants.IslandOccupant;
import islandOccupants.OccupantFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static islandOccupants.OccupantFactory.createOccupant;

public class Location {
    private static final AtomicInteger counter = new AtomicInteger();
    private final CopyOnWriteArrayList<IslandOccupant> listOfOccupants;
    private final ConcurrentHashMap<String, AtomicInteger> listWithNumberOfOccupantsOnLocation = new ConcurrentHashMap<>();

    public Location() {
        listOfOccupants = new CopyOnWriteArrayList<>();
        setInitialListWithNumberOfOccupantsOnLocation();
    }

    public CopyOnWriteArrayList<IslandOccupant> getListOfOccupants() {
        return listOfOccupants;
    }

    public void addOccupantInLocation(IslandOccupant occupant) {
        listOfOccupants.add(occupant);
    }

    public synchronized void startAnimalAmountCreator() { // название мб поменять
        OccupantFactory.setLocation(this);
        this.getListWithNumberOfOccupantsOnLocation().forEach((key, value) -> {
            AtomicInteger max = this.getListWithNumberOfOccupantsOnLocation().get(key); // AtomicInteger нужно сделать, скорее всего
            for (AtomicInteger i = new AtomicInteger(); i.get() < max.get(); i.getAndIncrement()) {
                createOccupant(key);
                counter.getAndIncrement();
                System.out.println(key + " from add occupant method");
            }
        });
    }

    public static AtomicInteger getCounter() {
        return counter;
    }

    public ConcurrentHashMap<String, AtomicInteger> getListWithNumberOfOccupantsOnLocation() {
        return listWithNumberOfOccupantsOnLocation;
    }

    private void setInitialListWithNumberOfOccupantsOnLocation() {
        List<String> keys = new ArrayList<>(List.of("wolf", "boa", "fox", "bear", "eagle", "horse",
                "deer", "rabbit", "mouse", "goat", "sheep", "boar", "buffalo", "duck", "caterpillar", "flower",
                "poisonFlower", "bush", "grass"));
        List<AtomicInteger> values = new ArrayList<>(List.of(
                new AtomicInteger(15),
                new AtomicInteger(15),
                new AtomicInteger(15),
                new AtomicInteger(2),
                new AtomicInteger(10),
                new AtomicInteger(10),
                new AtomicInteger(10),
                new AtomicInteger(75),
                new AtomicInteger(250),
                new AtomicInteger(70),
                new AtomicInteger(70),
                new AtomicInteger(25),
                new AtomicInteger(5),
                new AtomicInteger(100),
                new AtomicInteger(500),
                new AtomicInteger(100),
                new AtomicInteger(50),
                new AtomicInteger(50),
                new AtomicInteger(200)));

        HashMap<String, AtomicInteger> map = keys.stream().collect(HashMap::new, (k, v) -> k.put(v, values.get(keys.indexOf(v))),
                Map::putAll);
        listWithNumberOfOccupantsOnLocation.putAll(map);
    }
}
