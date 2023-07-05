package islandOccupants.animals.preadators;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Fox extends Predator {

    static {
        setMaxAmountOfOccupantsOnLocation(30);
    }

    public Fox(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(8.0));
    }

}
