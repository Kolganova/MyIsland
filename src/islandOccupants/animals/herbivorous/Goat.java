package islandOccupants.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Goat extends Herbivorous {

    public Goat(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(140, false, 60, 10, 3);
        location.addOccupantInLocation(this);
    }
}
