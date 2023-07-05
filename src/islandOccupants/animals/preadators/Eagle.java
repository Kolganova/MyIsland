package islandOccupants.animals.preadators;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;


public class Eagle extends Predator {

    static {
        setMaxAmountOfOccupantsOnLocation(20);
    }

    public Eagle(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
        setWeight(new AtomicReference<>(6.0));
    }
}
