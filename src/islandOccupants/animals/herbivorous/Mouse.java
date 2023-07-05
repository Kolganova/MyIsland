package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Mouse extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(500);
    }

    public Mouse(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
        setWeight(new AtomicReference<>(0.05));
    }

}
