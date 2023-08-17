package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Bear extends Predator {

    public Bear(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(5, false, 500, 80, 2);
        location.addOccupantInLocation(this);
    }

}
