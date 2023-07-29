package island;

import enums.CreationType;
import islandOccupants.IslandOccupant;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static islandOccupants.OccupantFactory.createOccupant;

public class Location {
    private final CopyOnWriteArrayList<IslandOccupant> listOfOccupants = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<String, AtomicInteger> mapWithOccupantsOnLocation = new ConcurrentHashMap<>();
    private int indexOfInnerList;
    private int indexOfExternalList;

    public Location() {
        primarySettingMapWithOccupantsOnLocation();
    }

    public synchronized boolean addOccupantInLocation(IslandOccupant occupant) {
        final int maxAmountOfOccupants = occupant.getMaxAmountOfOccupants();
        final int currentAmountOfOccupants = mapWithOccupantsOnLocation.get(occupant.getType()).get();
        if (maxAmountOfOccupants > currentAmountOfOccupants) {
            listOfOccupants.add(occupant);
            this.incrementAmountOfOccupantsOnLocation(occupant.getType());

            return true;
        }

        return false;
    }

    protected synchronized void primaryAnimalsCreator() {
        for (String type : this.getMapWithOccupantsOnLocation().keySet()) {
            if ("deadAnimal".equals(type))
                continue;
            IslandOccupant occupant = createOccupant(this, type, CreationType.START_OCCUPANT);
            int max = (Objects.requireNonNull(occupant).getMaxAmountOfOccupants() / 2 - 1);
            for (int i = 0; i < max; i++) {
                createOccupant(this, type, CreationType.START_OCCUPANT);
            }
        }
    }

    private void primarySettingMapWithOccupantsOnLocation() {

        List<String> listOfOccupantsType = new ArrayList<>(List.of("wolf", "boa", "fox", "bear",
                "eagle", "horse", "deer", "rabbit", "mouse", "goat", "sheep", "boar", "buffalo", "duck",
                "caterpillar", "flower", "poisonFlower", "bush", "grass", "deadAnimal"));

        HashMap<String, AtomicInteger> map = listOfOccupantsType
                .stream()
                .collect(HashMap::new, (k, v) -> k.put(v, new AtomicInteger()), Map::putAll);

        mapWithOccupantsOnLocation.putAll(map);
    }

    public synchronized void incrementAmountOfOccupantsOnLocation(String type) {
        mapWithOccupantsOnLocation.computeIfPresent(type, (key, value) -> {
            value.incrementAndGet();
            return value;
        });
    }

    public synchronized void decrementAmountOfOccupantsOnLocation(String type) {
        mapWithOccupantsOnLocation.computeIfPresent(type, (key, value) -> {
            value.decrementAndGet();
            return value;
        });
    }

    public ConcurrentHashMap<String, AtomicInteger> getMapWithOccupantsOnLocation() {
        return mapWithOccupantsOnLocation;
    }

    public int getIndexOfInnerList() {
        return indexOfInnerList;
    }

    public void setIndexOfInnerList(int indexOfInnerList) {
        this.indexOfInnerList = indexOfInnerList;
    }

    public int getIndexOfExternalList() {
        return indexOfExternalList;
    }

    public void setIndexOfExternalList(int indexOfExternalList) {
        this.indexOfExternalList = indexOfExternalList;
    }

    public CopyOnWriteArrayList<IslandOccupant> getListOfOccupants() {
        return listOfOccupants;
    }


}
