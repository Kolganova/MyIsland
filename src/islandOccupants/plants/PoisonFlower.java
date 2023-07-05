package islandOccupants.plants;

import island.Location;

public class PoisonFlower extends Plant {
    public PoisonFlower(Location location, String type) {
        super(location, type);
        setIsPoisonous(true);
    }

}
