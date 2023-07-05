package islandOccupants.animals.preadators;

import island.Location;


public class Eagle extends Predator {

    public Eagle(Location location, String type) {
        super(location, type);
        setIsPoisonProtected(true);
    }
}
