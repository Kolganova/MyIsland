package model.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Buffalo extends Herbivorous {

    public Buffalo(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(10, false,700, 100, 3);
        location.addOccupantInLocation(this);
    }

}
