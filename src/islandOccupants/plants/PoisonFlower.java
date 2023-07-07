package islandOccupants.plants;

import enums.CreationType;
import island.Location;

public class PoisonFlower extends Plant {

    public PoisonFlower(Location location, String type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(100);
        setIsPoisonous(true);
        setWeight(1.0);
        setPropagationFrequency(1);
        location.addOccupantInLocation(this);
    }

}
