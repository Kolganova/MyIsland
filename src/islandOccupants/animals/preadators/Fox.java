package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Fox extends Predator {

    public Fox(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(30, false, 8, 2, 2);
        location.addOccupantInLocation(this);
    }

}
