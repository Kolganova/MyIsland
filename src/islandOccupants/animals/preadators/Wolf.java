package islandOccupants.animals.preadators;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Wolf extends Predator {

    static {
        setMaxAmountOfOccupantsOnLocation(30);
    }

    public Wolf(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(50.0));
    }
}
