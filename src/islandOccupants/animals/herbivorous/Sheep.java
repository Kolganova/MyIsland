package islandOccupants.animals.herbivorous;

import island.Location;

import java.util.concurrent.atomic.AtomicReference;

public class Sheep extends Herbivorous {

    static {
        setMaxAmountOfOccupantsOnLocation(140);
    }

    public Sheep(Location location, String type) {
        super(location, type);
        setWeight(new AtomicReference<>(70.0));
    }

}
