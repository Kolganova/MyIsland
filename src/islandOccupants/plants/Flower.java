package islandOccupants.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Flower extends Plant {

    public Flower(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initPlant(200, false, 1, 2);
        location.addOccupantInLocation(this);
    }

}
