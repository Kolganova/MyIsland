package model.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Caterpillar extends Herbivorous {

    public Caterpillar(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(1000, true, 0.01, 0.1, 0);
        location.addOccupantInLocation(this);
    }

}
