package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Duck extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(200);
    }

    public Duck(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(1.0));
    }

}
