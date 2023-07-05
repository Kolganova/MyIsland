package islandOccupants.animals.preadators;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Boa extends Predator {

    static {
        setMaxAmountOfOccupantsOnLocation(30);
    }
    public Boa(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
        setWeight(new AtomicReference<>(15.0));
    }

}
