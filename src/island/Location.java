package island;

import enums.types.CreationType;
import enums.types.OccupantType;
import islandOccupants.IslandOccupant;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static enums.types.OccupantType.DEAD_ANIMAL;
import static islandOccupants.OccupantFactory.createOccupant;

@Getter
@Setter
public class Location {
    private final CopyOnWriteArrayList<IslandOccupant> listOfOccupants = new CopyOnWriteArrayList<>();
    private final ConcurrentHashMap<OccupantType, AtomicInteger> mapWithOccupantsOnLocation = new ConcurrentHashMap<>();
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
        for (OccupantType type : this.getMapWithOccupantsOnLocation().keySet()) {
            if (DEAD_ANIMAL.equals(type))
                continue;
            IslandOccupant occupant = createOccupant(this, type, CreationType.START_OCCUPANT);
            int max = occupant.getMaxAmountOfOccupants() / 2 - 1;
            for (int i = 0; i < max; i++) {
                createOccupant(this, type, CreationType.START_OCCUPANT);
            }
        }
    }

    private void primarySettingMapWithOccupantsOnLocation() {

        EnumSet<OccupantType> occupantTypeEnumSet = EnumSet.allOf(OccupantType.class);

        HashMap<OccupantType, AtomicInteger> map = occupantTypeEnumSet
                .stream()
                .collect(HashMap::new, (k, v) -> k.put(v, new AtomicInteger()), Map::putAll);

        mapWithOccupantsOnLocation.putAll(map);
    }

    public void incrementAmountOfOccupantsOnLocation(OccupantType type) {
        mapWithOccupantsOnLocation.computeIfPresent(type, (key, value) -> {
            value.incrementAndGet();
            return value;
        });
    }

    public void decrementAmountOfOccupantsOnLocation(OccupantType type) {
        mapWithOccupantsOnLocation.computeIfPresent(type, (key, value) -> {
            value.decrementAndGet();
            return value;
        });
    }

}