package islandOccupants.animals.preadators;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Bear extends Predator {

    static {
        setMaxAmountOfOccupantsOnLocation(5);
    }

    public Bear(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(500.0));
    }

}
