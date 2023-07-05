package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Rabbit extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(150);
    }

    public Rabbit(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(2.0));
    }

}
