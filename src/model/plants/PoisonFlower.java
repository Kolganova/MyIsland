package model.plants;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class PoisonFlower extends Plant {

    public PoisonFlower(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initPlant(100, true, 1, 1);
        location.addOccupantInLocation(this);
    }

}
