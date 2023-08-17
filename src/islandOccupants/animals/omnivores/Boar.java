package islandOccupants.animals.omnivores;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Boar extends Omnivores {

    public Boar(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        initAnimal(50, true, 400, 50, 2);
        location.addOccupantInLocation(this);
    }

}
