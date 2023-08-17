package islandOccupants.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Grass extends Plant {

    public Grass(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initPlant(400, false, 1, 3);
        location.addOccupantInLocation(this);
    }

}
