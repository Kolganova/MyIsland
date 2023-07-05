package islandOccupants.plants;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class PoisonFlower extends Plant {

    static {
        setMaxAmountOfOccupantsOnLocation(100);
    }

    public PoisonFlower(Location location, String type) {
        super(location, type);
        setIsPoisonous(true);
        setWeight(new AtomicReference<>(1.0));
    }

}
