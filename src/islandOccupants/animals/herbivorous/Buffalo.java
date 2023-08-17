package islandOccupants.animals.herbivorous;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Buffalo extends Herbivorous {

    public Buffalo(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(10, false,700, 100, 3);
        location.addOccupantInLocation(this);
    }

}
