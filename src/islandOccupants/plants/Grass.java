package islandOccupants.plants;

import island.Location;

public class Grass extends Plant {

    public Grass(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(400);
        setWeight(1.0);
        location.addOccupantInLocation(this);
    }
}
