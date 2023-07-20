package islandOccupants.plants;

import enums.CreationType;
import island.Location;

public class Bush extends Plant {

    public Bush(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(50);
        setIsPoisonous(false);
        setWeight(3.0);
        setPropagationFrequency(1);
        location.addOccupantInLocation(this);
    }

}
