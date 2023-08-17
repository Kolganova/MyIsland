package islandOccupants.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Deer extends Herbivorous {

    public Deer(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(20, false, 300, 50, 4);
        location.addOccupantInLocation(this);
    }

}
