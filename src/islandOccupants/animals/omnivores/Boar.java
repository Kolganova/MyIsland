package islandOccupants.animals.omnivores;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Boar extends Omnivores {

    static {
        setMaxAmountOfOccupantsOnLocation(50);
    }

    public Boar(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
        setWeight(new AtomicReference<>(400.0));
    }

}
