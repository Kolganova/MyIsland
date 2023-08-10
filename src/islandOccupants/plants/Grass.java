package islandOccupants.plants;

import enums.CreationType;
import enums.OccupantType;
import island.Location;

public class Grass extends Plant {

    public Grass(Location location, OccupantType type, CreationType creationType) {
        super(location, type, creationType);
        setMaxAmountOfOccupants(400);
        setIsPoisonous(false);
        setWeight(1.0);
        setPropagationFrequency(3);
        location.addOccupantInLocation(this);
    }
}
