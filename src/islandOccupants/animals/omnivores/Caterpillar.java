package islandOccupants.animals.omnivores;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Caterpillar extends Omnivores {

    static {
        setMaxAmountOfOccupantsOnLocation(1000);
    }

    public Caterpillar(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
        setWeight(new AtomicReference<>(0.01));
    }
}
