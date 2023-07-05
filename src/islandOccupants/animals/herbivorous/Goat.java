package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Goat extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(140);
    }

    public Goat(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(60.0));
    }
}
