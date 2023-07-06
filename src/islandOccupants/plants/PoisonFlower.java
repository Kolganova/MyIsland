package islandOccupants.plants;

import island.Location;

public class PoisonFlower extends Plant {

    public PoisonFlower(Location location, String type) {
        super(location, type);
        setMaxAmountOfOccupants(100);
        setIsPoisonous(true);
        setWeight(1.0);
        location.addOccupantInLocation(this);
    }

}
