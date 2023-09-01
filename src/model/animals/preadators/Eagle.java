package model.animals.preadators;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Eagle extends Predator {

    public Eagle(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(20, true, 6, 1, 3);
        location.addOccupantInLocation(this);
    }
}
