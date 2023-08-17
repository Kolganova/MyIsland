package islandOccupants.animals.preadators;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Boa extends Predator {

    public Boa(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(30, true, 15, 3.0, 1);
        location.addOccupantInLocation(this);
    }

}
