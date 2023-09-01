package model.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Horse extends Herbivorous {

    public Horse(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(20, false, 400, 60, 4);
        location.addOccupantInLocation(this);
    }
}
