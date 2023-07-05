package islandOccupants.plants;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Grass extends Plant {

    static {
        setMaxAmountOfOccupantsOnLocation(400);
    }

    public Grass(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(1.0));
    }
}
