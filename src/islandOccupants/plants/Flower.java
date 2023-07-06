package islandOccupants.plants;

import island.Location;

public class Flower extends Plant {

    public Flower(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(200);
        setWeight(1.0);
        location.addOccupantInLocation(this);
    }

}
