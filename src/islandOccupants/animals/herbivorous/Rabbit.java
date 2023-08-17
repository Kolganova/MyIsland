package islandOccupants.animals.herbivorous;

import enums.types.CreationType;
import enums.types.OccupantType;
import island.Location;

public class Rabbit extends Herbivorous {

    public Rabbit(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(150, false, 2.0, 0.45, 2);
        location.addOccupantInLocation(this);
    }

}
