package islandOccupants.plants;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Flower extends Plant {

    static {
        setMaxAmountOfOccupantsOnLocation(200);
    }

    public Flower(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(1.0));
    }
}
