package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Deer extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(20);
    }

    public Deer(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(300.0));
    }
}
