package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Horse extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(20);
    }

    public Horse(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(400.0));
    }
}
