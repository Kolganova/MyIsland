package model.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Mouse extends Herbivorous {

    public Mouse(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(500, true, 0.05, 0.01, 1);
        location.addOccupantInLocation(this);
    }

}
