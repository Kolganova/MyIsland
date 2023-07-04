package islandOccupants.animals.preadators;

import island.Location;

public class Fox extends Predator {
    private int id;
    Location location;

    public Fox(Location location) {
        super(location);
        this.location = location;
    }


}
