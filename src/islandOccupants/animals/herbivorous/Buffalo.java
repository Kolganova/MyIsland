package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Buffalo extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(10);
    }

    public Buffalo(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(700.0));
    }

}
