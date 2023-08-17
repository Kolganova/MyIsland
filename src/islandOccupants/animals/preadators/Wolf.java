package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Wolf extends Predator {

    public Wolf(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(30, false, 50, 8, 3);
        location.addOccupantInLocation(this);
    }
}
